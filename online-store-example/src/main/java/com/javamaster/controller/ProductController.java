package com.javamaster.controller;

import com.javamaster.entity.ProductEntity;
import com.javamaster.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("products")
@Slf4j
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping()
    public List<ProductEntity> getAllProduct() {
        log.info("handling get all products request");
        return productService.getAllProducts();
    }

    @GetMapping("/{productId}")
    public ProductEntity getProductById(@PathVariable("productId") Integer productId) {
        log.info("handling get product by id request");
        return productService.getProductById(productId);
    }
}
