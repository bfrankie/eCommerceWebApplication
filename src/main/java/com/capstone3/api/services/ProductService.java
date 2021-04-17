package com.capstone3.api.services;


import com.capstone3.api.entities.Category;
import com.capstone3.api.entities.Product;
import com.capstone3.api.repos.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepo productRepo;

    public List<Product> getProducts() {
        Iterable<Product> productIterable = productRepo.findAll();
        List<Product> productList = new ArrayList<>();
        productIterable.forEach(productList::add);
        return productList;
    }
//
//    Optional<Product> findByTitle(String title);

    public Optional<Product> getProductByTitle(String title) {
        return productRepo.findByTitle(title);
    }
//    Optional<Product> findByDetails(String details);

    public Optional<Product> getProductByDetails(String details) {
        return productRepo.findByDetails(details);
    }

    public Optional<Product> getProductByCategory(String category) {
        return productRepo.findByCategory(category);
}

    public Optional<Product> getProductBySerialNumber(int serialNumber) {
        return productRepo.findBySerialNumber(serialNumber);
    }

    public Optional<Product> getProductByPrice(BigDecimal price) {
        return productRepo.findByPrice(price);
    }

    public Product createProduct(Product p) {
        return productRepo.save(p);
    }

    public Product updateProduct(int serialNumber, Product product) {
        Optional<Product> oProduct = getProductBySerialNumber(serialNumber);

        if(oProduct.isPresent()) {
            Product updatedProduct = oProduct.get();
            String updatedTitle = updatedProduct.getTitle();
            BigDecimal updatedPrice = updatedProduct.getPrice();
            int updatedSerialNumber = updatedProduct.getSerialNumber();
            String updatedImgURL1 = updatedProduct.getImgURL1();
            String updatedImgURL2 = updatedProduct.getImgURL2();
            String updatedImgURL3 = updatedProduct.getImgURL3();
            String updatedImgURL4 = updatedProduct.getImgURL4();
            String updatedImgURL5 = updatedProduct.getImgURL5();
            String updatedDetails = updatedProduct.getDetails();
            Category updatedCategory = updatedProduct.getCategory();
            int updatedQuantity = updatedProduct.getQuantity();

            updatedProduct.setTitle(updatedTitle);
            updatedProduct.setPrice(updatedPrice);
            updatedProduct.setSerialNumber(updatedSerialNumber);
            updatedProduct.setImgURL1(updatedImgURL1);
            updatedProduct.setImgURL2(updatedImgURL2);
            updatedProduct.setImgURL3(updatedImgURL3);
            updatedProduct.setImgURL4(updatedImgURL4);
            updatedProduct.setImgURL5(updatedImgURL5);
            updatedProduct.setDetails(updatedDetails);
            updatedProduct.setCategory(updatedCategory);
            updatedProduct.setQuantity(updatedQuantity);
            return productRepo.save(updatedProduct);
        }
        return product;
    }

    public void deleteProduct(String title) {
        productRepo.deleteByTitle(title);
    }

    public void deleteProduct(int serialNumber) {
        productRepo.deleteBySerialNumber(serialNumber);
    }
}
