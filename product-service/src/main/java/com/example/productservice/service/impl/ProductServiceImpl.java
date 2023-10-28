package com.example.productservice.service.impl;

import com.example.productservice.dto.ProductDto;
import com.example.productservice.model.Product;
import com.example.productservice.repository.ProductRepository;
import com.example.productservice.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final UtilService utilService;

    public void createProduct(ProductDto productDto){
        Product product = Product.builder()
                .name(productDto.getName())
                .description(productDto.getDescription())
                .price(productDto.getPrice())
                .build();
        productRepository.save(product);
        log.info("product {} is saved",product.getId());
    }

    public List<ProductDto> getAllProducts() {
       List<Product> products = productRepository.findAll();
       return products.stream().map(utilService::mapToProductDto).toList();
    }
}
