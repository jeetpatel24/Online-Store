package com.javamaster.service;

import com.javamaster.entity.ProductEntity;

import java.util.List;

public interface ProductService {

    List<ProductEntity> getAllProducts();

    ProductEntity getProductById(Integer productId);
}
