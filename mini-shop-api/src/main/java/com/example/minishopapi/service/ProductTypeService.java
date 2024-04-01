package com.example.minishopapi.service;

import com.example.minishopapi.entity.ProductType;
import com.example.minishopapi.model.*;
import com.example.minishopapi.repository.ProductTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Service
public class ProductTypeService {

    @Autowired
    private ProductTypeRepository productTypeRepository;

    @Autowired
    private ValidationService validationService;

    @Transactional
    public ProductTypeResponse create(CreateProductTypeRequest request){
        validationService.validate(request);

        ProductType productType = new ProductType();
        productType.setId(UUID.randomUUID().toString());
        productType.setName(request.getName());
        productType.setCreatedAt(getCurrentTimestamp());

        productTypeRepository.save(productType);

        return toProductTypeResponse(productType);
    }

    private ProductTypeResponse toProductTypeResponse(ProductType productType){
        return ProductTypeResponse.builder()
                .id(productType.getId())
                .name(productType.getName())
                .createdAt(productType.getCreatedAt())
                .updatedAt(productType.getUpdatedAt())
                .build();
    }

    @Transactional
    public ProductTypeResponse update(UpdateProductTypeRequest request){
        validationService.validate(request);

        ProductType productType = productTypeRepository.findById(request.getId())
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product Type not found"));

        productType.setName(request.getName());
        productType.setUpdatedAt(getCurrentTimestamp());
        productTypeRepository.save(productType);

        return toProductTypeResponse(productType);
    }

    @Transactional(readOnly = true)
    public ProductTypeResponse get(String id){
        ProductType productType = productTypeRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product Type not found"));

        return toProductTypeResponse(productType);
    }

    @Transactional(readOnly = true)
    public List<ProductTypeResponse> getList(){
        List<ProductType> productTypes = productTypeRepository.findAll();

        return productTypes.stream()
                .map(this::toProductTypeResponse)
                .toList();
    }

    private Timestamp getCurrentTimestamp(){
        return new Timestamp(System.currentTimeMillis());
    }
}

