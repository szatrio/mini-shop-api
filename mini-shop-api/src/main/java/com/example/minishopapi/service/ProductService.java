package com.example.minishopapi.service;


import com.example.minishopapi.entity.Product;
import com.example.minishopapi.entity.ProductType;
import com.example.minishopapi.model.*;
import com.example.minishopapi.repository.ProductRepository;
import com.example.minishopapi.repository.ProductTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductTypeRepository productTypeRepository;

    @Autowired
    private ValidationService validationService;

    @Transactional
    public ProductResponse create(CreateProductRequest request){
        validationService.validate(request);

        ProductType productType = productTypeRepository.findById(request.getProductTypeId())
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product Type not found"));
        Product product = new Product();
        product.setId(UUID.randomUUID().toString());
        product.setName(request.getName());
        product.setPrice(request.getPrice());
        product.setProductType(productType);
        product.setCreatedAt(getCurrentTimestamp());

        productRepository.save(product);

        return toProductResponse(product);
    }

    private ProductResponse toProductResponse(Product product){
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .productType(product.getProductType().getName())
                .createdAt(product.getCreatedAt())
                .updatedAt(product.getUpdatedAt())
                .build();
    }

    @Transactional
    public ProductResponse update(UpdateProductRequest request){
        validationService.validate(request);

        Product product = productRepository.findById(request.getId())
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found"));

        ProductType productType = productTypeRepository.findById(request.getProductTypeId())
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product Type not found"));

        product.setName(request.getName());
        product.setPrice(request.getPrice());
        product.setProductType(productType);
        product.setUpdatedAt(getCurrentTimestamp());
        productRepository.save(product);

        return toProductResponse(product);
    }

    @Transactional(readOnly = true)
    public ProductResponse get(String id){
        Product product = productRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found"));

        return toProductResponse(product);
    }

    @Transactional(readOnly = true)
    public Page<ProductResponse> getList(ProductListRequest  request){

        Pageable pageable = PageRequest.of(request.getPage(), request.getLimit());
        Page<Product> products = productRepository.findAll(pageable);

        List<ProductResponse> productResponses = products.stream()
                .map(this::toProductResponse)
                .toList();

        return new PageImpl<>(productResponses, pageable, products.getTotalElements());
    }

    @Transactional
    public void delete(String id){
        Product product = productRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found"));

        productRepository.delete(product);
    }

    private Timestamp getCurrentTimestamp(){
        return new Timestamp(System.currentTimeMillis());
    }
}

