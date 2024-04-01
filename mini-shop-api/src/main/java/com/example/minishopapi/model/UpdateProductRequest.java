package com.example.minishopapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateProductRequest {

    @JsonIgnore
    @NotBlank
    private String id;

    @NotBlank
    @Size( max = 100)
    private String name;

    @NotBlank
    @Size( max = 100)
    private Integer price;

    @NotBlank
    @Size( max = 100)
    private String productTypeId;

}
