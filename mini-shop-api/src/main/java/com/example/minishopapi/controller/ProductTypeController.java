package com.example.minishopapi.controller;

import com.example.minishopapi.model.*;
import com.example.minishopapi.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductTypeController {

    @Autowired
    private ProductTypeService productTypeService;

    @PostMapping(
            path = "/api/product-types",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<ProductTypeResponse> create(@RequestBody CreateProductTypeRequest request){
        ProductTypeResponse productTypeResponse = productTypeService.create(request);
        return WebResponse.<ProductTypeResponse>builder().data(productTypeResponse).build();
    }

    @PutMapping(
            path = "/api/product-types/{productTypeId}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<ProductTypeResponse> update(@RequestBody UpdateProductTypeRequest request,
                                                @PathVariable("productTypeId") String productTypeId
    ){
        request.setId(productTypeId);

        ProductTypeResponse productTypeResponse = productTypeService.update(request);
        return WebResponse.<ProductTypeResponse>builder()
                .data(productTypeResponse)
                .build();
    }

    @GetMapping(
            path = "/api/product-types/{productTypeId}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<ProductTypeResponse> get(@PathVariable("productTypeId") String productTypeId ){
        ProductTypeResponse productTypeResponse = productTypeService.get(productTypeId);
        return WebResponse.<ProductTypeResponse>builder()
                .data(productTypeResponse)
                .build();
    }

    @GetMapping(
            path = "/api/product-types",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<List<ProductTypeResponse>> getList(){
        List<ProductTypeResponse> productTypeResponse = productTypeService.getList();
        return WebResponse.<List<ProductTypeResponse>>builder()
                .data(productTypeResponse)
                .build();
    }
}

