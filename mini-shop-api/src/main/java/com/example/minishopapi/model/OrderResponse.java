package com.example.minishopapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderResponse {

    private String id;

    private String customer;

    private List<CartProductResponse> listProduct;

    private Integer total;

    private Timestamp createdAt;
}
