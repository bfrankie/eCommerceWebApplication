package com.capstone3.api.controllers;


import com.capstone3.api.entities.Product;
import com.capstone3.api.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;


    @GetMapping(path="/all-products")
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Product> getAllProducts() {
        return productService.getProducts();
    }

    @GetMapping(path="/products-by-title")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Product> productByTitle(String title) {
        return productService.getProductByTitle(title);
    }

    @GetMapping(path="/products-by-details")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Product> productByDetails(String details) {
        return productService.getProductByDetails(details);
    }

    @GetMapping(path="/products-by-category")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Product> productByCategory(String category) {
        return productService.getProductByCategory(category);
    }

    @GetMapping(path="/products-by-serial-number")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Product> productBySerialNumber(int serialNumber) {
        return productService.getProductBySerialNumber(serialNumber);
    }

    @GetMapping(path="/products-by-price")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Product> productByPrice(BigDecimal price) {
        return productService.getProductByPrice(price);
    }

    @PostMapping(path = "/create-product")
    @ResponseStatus(HttpStatus.CREATED)
    public Product createProduct(@RequestBody Product p) {
        return productService.createProduct(p);
    }

    @PutMapping(path = "/update-product-by-serial-number")
    @ResponseStatus(HttpStatus.OK)
    public Product updateProductBySerialNumber(@PathVariable int serialNumber, Product p) {
        return productService.updateProduct(serialNumber, p);
    }

    @DeleteMapping(path = "/delete-product-by-title")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProductByTitle(String title) {
        productService.deleteProduct(title);
    }

    @DeleteMapping(path = "/delete-product-by-serial-number")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProductBySerialNumber(int serialNumber) {
        productService.deleteProduct(serialNumber);
    }





}
