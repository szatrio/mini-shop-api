package com.example.minishopapi.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PlaceOrderRequest {

    @NotBlank
    @Size( max = 100)
    private String customerId;

    @NotBlank
    @Size( max = 100)
    private List<String> cartProductIdList;

}
