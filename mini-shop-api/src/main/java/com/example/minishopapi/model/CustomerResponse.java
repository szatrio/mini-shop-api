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
public class CustomerResponse {

    private String id;

    private String name;

    private String address;

    private Timestamp createdAt;

    private Timestamp updatedAt;
}
