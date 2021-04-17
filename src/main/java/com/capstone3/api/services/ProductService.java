package com.capstone3.api.services;


import com.capstone3.api.entities.Category;
import com.capstone3.api.entities.Product;
import com.capstone3.api.repos.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
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

    public Optional<Product> getProductByTitle(String title) {
        return productRepo.findByTitle(title);
    }

    public List<Optional<Product>> getProductByDetails(String details) {

        List<Product> productList = getProducts();
        List<String> wordsToSearchFor = new ArrayList<>();
        List<String> wordsToSearchAgainst = new ArrayList<>();
        List<Optional<Product>> matchingProducts = new ArrayList<>();

        //Get list of words in string details
        wordsToSearchFor.addAll(Arrays.asList(details.split(" ")));

        for(Product p : productList) {
            wordsToSearchAgainst.clear();
            //Get list of words in details of each product
            for (String word : p.getDetails().split(" ")) {
                wordsToSearchAgainst.add(word.toLowerCase());
            }

            //Compare, and if there is a match add product to new product list
            for(String word : wordsToSearchFor) {
                if(wordsToSearchAgainst.contains(word.toLowerCase())) {
                    matchingProducts.add(Optional.of(p));
                    return matchingProducts;
                }
            }
        }

        if(matchingProducts.isEmpty()) {
            return null;
        }
        return matchingProducts;
    }

    public List<Optional<Product>> getProductByCategory(String categoryName) {
        List<Product> productList = getProducts();
        List<Optional<Product>> matchingProducts = new ArrayList<>();

        for(Product p : productList) {
            if(categoryName.equalsIgnoreCase(p.getCategory().getCategoryName())) {
                matchingProducts.add(Optional.of(p));
                return matchingProducts;
            }
        }
        return matchingProducts;
    }

    public Optional<Product> getProductBySerialNumber(int serialNumber) {
        return productRepo.findBySerialNumber(serialNumber);
    }

    public Optional<List<Product>> getProductByPrice(BigDecimal price) {
        return productRepo.findByPrice(price);
    }

    public Product createProduct(Product p) {
        return productRepo.save(p);
    }

    public Product updateProduct(int serialNumber, Product product) {
        Optional<Product> oProduct = getProductBySerialNumber(serialNumber);

        if(oProduct.isPresent()) {
            Product updatedProduct = oProduct.get();
            String updatedTitle = product.getTitle();
            BigDecimal updatedPrice = product.getPrice();
            int updatedSerialNumber = product.getSerialNumber();
            String updatedImgURL1 = product.getImgURL1();
            String updatedImgURL2 = product.getImgURL2();
            String updatedImgURL3 = product.getImgURL3();
            String updatedImgURL4 = product.getImgURL4();
            String updatedImgURL5 = product.getImgURL5();
            String updatedDetails = product.getDetails();
            Category updatedCategory = product.getCategory();
            int updatedQuantity = product.getQuantity();

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
