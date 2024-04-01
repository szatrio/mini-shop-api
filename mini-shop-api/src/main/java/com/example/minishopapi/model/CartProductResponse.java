package com.example.minishopapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CartProductResponse {

    private String id;

    private String productName;

    private Integer productPrice;

    private Integer qty;

    private Integer totalCartProduct;

    private Timestamp createdAt;

    private Timestamp updatedAt;
}
