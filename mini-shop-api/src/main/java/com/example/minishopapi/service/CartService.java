package com.example.minishopapi.service;

import com.example.minishopapi.entity.*;
import com.example.minishopapi.model.*;
import com.example.minishopapi.repository.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Timestamp;
import java.util.*;

@Slf4j
@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartProductRepository cartProductRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ValidationService validationService;

    @Transactional
    public CartResponse addToCart(AddToCartRequest request){
        validationService.validate(request);

        Customer customer = customerRepository.findById(request.getCustomerId())
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found"));

        Product product = productRepository.findById(request.getProductId())
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product Type not found"));

        Cart cart = cartRepository.findFirstByCustomer_Id(request.getCustomerId())
                .orElse(new Cart());

        if(cart.getId() == null){
            cart.setId(UUID.randomUUID().toString());
            cart.setCustomer(customer);
            cart.setCreatedAt(getCurrentTimestamp());

            cartRepository.save(cart);
        }

        CartProduct cartProduct = new CartProduct();
        cartProduct.setId(UUID.randomUUID().toString());
        cartProduct.setProduct(product);
        cartProduct.setQty(request.getQty());
        cartProduct.setCart(cart);
        cartProduct.setCreatedAt(getCurrentTimestamp());

        cartProductRepository.save(cartProduct);

        List<CartProduct> cartProductList = cartProductRepository.findAllByCart_Id(cart.getId());

        int totalCart = 0;

        List<CartProductResponse> cartProductResponses = new ArrayList<CartProductResponse>();

        for (CartProduct itemCartProduct : cartProductList) {
            int totalCartProduct = itemCartProduct.getQty() * itemCartProduct.getProduct().getPrice();

            totalCart += totalCartProduct;

            CartProductResponse cartProductResponse = toCartProductresponse(itemCartProduct, totalCartProduct);

            cartProductResponses.add(cartProductResponse);
        }

        return CartResponse.builder()
                .id(cart.getId())
                .customer(cart.getCustomer().getName())
                .listProduct(cartProductResponses)
                .totalCart(totalCart)
                .createdAt(cart.getCreatedAt())
                .build();
    }

    private CartProductResponse toCartProductresponse(CartProduct cartProduct, int totalCartProduct){
        CartProductResponse cartProductResponse = new CartProductResponse();
        cartProductResponse.setId(cartProduct.getId());
        cartProductResponse.setProductName(cartProduct.getProduct().getName());
        cartProductResponse.setProductPrice(cartProduct.getProduct().getPrice());
        cartProductResponse.setQty(cartProduct.getQty());
        cartProductResponse.setTotalCartProduct(totalCartProduct);
        cartProductResponse.setCreatedAt(cartProduct.getCreatedAt());
        cartProductResponse.setUpdatedAt(cartProduct.getUpdatedAt());

        return cartProductResponse;
    }

    @Transactional
    public OrderResponse placeOrder(PlaceOrderRequest request){
        validationService.validate(request);

        Customer customer = customerRepository.findById(request.getCustomerId())
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found"));

        int totalCart = 0;

        List<CartProductResponse> cartProductResponses = new ArrayList<CartProductResponse>();
        List<CartProduct> tempDeleteCartProduct = new ArrayList<CartProduct>();

        for (String cartProductId : request.getCartProductIdList()) {
            CartProduct cartProduct = cartProductRepository.findById(cartProductId)
                    .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Card product ID does matched any Card product with this user"));

            int totalCartProduct = cartProduct.getQty() * cartProduct.getProduct().getPrice();
            totalCart += totalCartProduct;

            CartProductResponse cartProductResponse = toCartProductresponse(cartProduct, totalCartProduct);

            cartProductResponses.add(cartProductResponse);
            tempDeleteCartProduct.add(cartProduct);
        }

        Order order = new Order();
        order.setId(UUID.randomUUID().toString());
        order.setTotal(totalCart);
        order.setCustomer(customer);
        order.setCreatedAt(getCurrentTimestamp());

        orderRepository.save(order);
        cartProductRepository.deleteAllInBatch(tempDeleteCartProduct);

        return OrderResponse.builder()
                .id(order.getId())
                .customer(order.getCustomer().getName())
                .listProduct(cartProductResponses)
                .total(order.getTotal())
                .createdAt(order.getCreatedAt())
                .build();
    }

    private Timestamp getCurrentTimestamp(){
        return new Timestamp(System.currentTimeMillis());
    }
}
