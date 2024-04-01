package com.example.minishopapi.controller;

import com.example.minishopapi.model.*;
import com.example.minishopapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping(
            path = "/api/products",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<ProductResponse> create(@RequestBody CreateProductRequest request){
        ProductResponse productResponse = productService.create(request);
        return WebResponse.<ProductResponse>builder().data(productResponse).build();
    }

    @PutMapping(
            path = "/api/products/{productId}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<ProductResponse> update(@RequestBody UpdateProductRequest request,
                                                   @PathVariable("productId") String productId
    ){
        request.setId(productId);

        ProductResponse productResponse = productService.update(request);
        return WebResponse.<ProductResponse>builder()
                .data(productResponse)
                .build();
    }

    @GetMapping(
            path = "/api/products/{productId}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<ProductResponse> get(@PathVariable("productId") String productId ){
        ProductResponse productResponse = productService.get(productId);
        return WebResponse.<ProductResponse>builder()
                .data(productResponse)
                .build();
    }

    @GetMapping(
            path = "/api/products",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<ProductListResponse> getList(@RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
                                                      @RequestParam(value = "limit", required = false, defaultValue = "10") Integer limit){

        ProductListRequest request = ProductListRequest.builder()
                .page(page)
                .limit(limit)
                .build();

        Page<ProductResponse> productResponseList = productService.getList(request);
        return WebResponse.<ProductListResponse>builder()
                .data(ProductListResponse.builder()
                        .list(productResponseList.getContent())
                        .pageInfo(PageInfo.builder()
                                .currentPage(productResponseList.getNumber())
                                .totalPage(productResponseList.getTotalPages())
                                .limit(productResponseList.getSize())
                                .totalData(productResponseList.getNumberOfElements())
                                .build())
                        .build()
                )
                .build();
    }

    @DeleteMapping(
            path = "/api/products/{productId}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<String> delete(@PathVariable("productId") String productId ){
        productService.delete(productId);
        return WebResponse.<String>builder().data("Product was deleted successfully").build();
    }
}
