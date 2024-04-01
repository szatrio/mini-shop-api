package com.example.minishopapi.controller;

import com.example.minishopapi.model.*;
import com.example.minishopapi.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping(
            path = "/api/carts",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<CartResponse> create(@RequestBody AddToCartRequest request){
        CartResponse cartResponse = cartService.addToCart(request);
        return WebResponse.<CartResponse>builder().data(cartResponse).build();
    }
}
