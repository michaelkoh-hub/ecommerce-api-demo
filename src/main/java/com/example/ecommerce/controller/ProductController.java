package com.example.ecommerce.controller;

import com.example.ecommerce.model.Product;
import com.example.ecommerce.service.ProductService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;
    
    // Test Flow
    // 1) Create Product = POST localhost:8080/api/products?categoryID=1&tagIds=1
    // 2) Get all product or get product by id = localhost:8080/api/products
    // 3) Get all categories, or get categoty by id = localhost:8080/api/categories
    @PostMapping
    public Product addProduct(@RequestBody Product products, @RequestParam Long categoryId, @RequestParam List<Long> tagIds) {
    	// Now create a new product I have to specify the category ID = DTO
    	// Temporary use RequestParam
    	// Best Practice user proper DTO
        return productService.createProduct(products, categoryId, tagIds);
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @Valid @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
    
}
