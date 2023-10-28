package com.example.productservice.service;

import com.example.productservice.dto.ProductDto;
import com.example.productservice.model.Product;

import java.util.List;

public interface ProductService {

     void createProduct(ProductDto productDto);


     List<ProductDto> getAllProducts();
}
