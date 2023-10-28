package com.example.productservice.service.impl;

import com.example.productservice.dto.ProductDto;
import com.example.productservice.model.Product;
import org.springframework.stereotype.Service;

@Service
public class UtilService {

    public ProductDto mapToProductDto(Product product){
        return ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice()).build();
    }
}
