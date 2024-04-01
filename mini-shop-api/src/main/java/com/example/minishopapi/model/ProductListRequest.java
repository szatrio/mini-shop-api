package com.example.minishopapi.model;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductListRequest {

    @NotBlank
    private Integer page;

    @NotBlank
    private Integer limit;
}
