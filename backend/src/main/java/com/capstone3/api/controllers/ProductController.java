package com.capstone3.api.controllers;


import com.capstone3.api.entities.Product;
import com.capstone3.api.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;


    @GetMapping(path="/all-products")
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Product> getAllProducts() {
        return productService.getProducts();
    }

    @GetMapping(path="/product-by-title/{title}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Product> productByTitle(@PathVariable String title) {
        return productService.getProductByTitle(title);
    }

    @GetMapping(path="/product-by-details/{details}")
    @ResponseStatus(HttpStatus.OK)
    public List<Optional<Product>> productByDetails(@PathVariable String details) {
        return productService.getProductByDetails(details);
    }

    @GetMapping(path="/product-by-category/{categoryName}")
    @ResponseStatus(HttpStatus.OK)
    public List<Optional<Product>> productByCategory(@PathVariable String categoryName) {
        return productService.getProductByCategory(categoryName);
    }

    @GetMapping(path="/product-by-serial-number/{serialNumber}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Product> productBySerialNumber(@PathVariable int serialNumber) {
        return productService.getProductBySerialNumber(serialNumber);
    }

    @GetMapping(path="/product-by-price/{price}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<List<Product>> productByPrice(@PathVariable BigDecimal price) {
        return productService.getProductByPrice(price);
    }

    @PostMapping(path = "/create-product")
    @ResponseStatus(HttpStatus.CREATED)
    public Product createProduct(@RequestBody Product p) {
        return productService.createProduct(p);
    }

    @PutMapping(path = "/update-product-by-serial-number/{serialNumber}")
    @ResponseStatus(HttpStatus.OK)
    public Product updateProductBySerialNumber(@PathVariable int serialNumber, @RequestBody Product p) {
        return productService.updateProduct(serialNumber, p);
    }

    @Transactional
    @DeleteMapping(path = "/delete-product-by-title/{title}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProductByTitle(@PathVariable String title) {
        productService.deleteProduct(title);
    }

    @Transactional
    @DeleteMapping(path = "/delete-product-by-serial-number/{serialNumber}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProductBySerialNumber(@PathVariable int serialNumber) {
        productService.deleteProduct(serialNumber);
    }





}
