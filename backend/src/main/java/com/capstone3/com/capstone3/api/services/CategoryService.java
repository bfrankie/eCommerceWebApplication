package com.capstone3.api.services;


import com.capstone3.api.entities.Category;
import com.capstone3.api.entities.Product;
import com.capstone3.api.repos.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    
    @Autowired
    CategoryRepo categoryRepo;
    
    public List<Category> getCategories() {
        Iterable<Category> categoryIterable = categoryRepo.findAll();
        List<Category> categoryList = new ArrayList<>();
        categoryIterable.forEach(categoryList::add);
        return categoryList;
    }

    public Optional<Category> getCategoryById(int id) {
        return categoryRepo.findById(id);
    }

    public Optional<Category> getCategoryByName(String name) {
        return categoryRepo.findByCategoryName(name);
    }

    public Category createCategory(Category c) {
        return categoryRepo.save(c);
    }
    
    public Category updateCategory(int id, Category category) {
        Optional<Category> oCategory = getCategoryById(id);
        Optional<List<Product>> oProduct = Optional.ofNullable(category.getProducts());

        if(oCategory.isPresent()) {
            Category updatedCategory = oCategory.get();
            String updatedName = category.getCategoryName();
            List<Product> updatedProductList = category.getProducts();

            updatedCategory.setCategoryName(updatedName);

            if(oProduct.isPresent()) {
                updatedCategory.setProducts(updatedProductList);
                for (Product p : updatedProductList) {
                    p.addCategory(updatedCategory);
                }
            }
            return categoryRepo.save(updatedCategory);
        }
        return category;
    }

    public void removeProductsList(int id) {
        Optional<Category> oCategory = categoryRepo.findById(id);
        if(oCategory.isPresent()) {
            Category c = oCategory.get();
            List<Product> productList = c.getProducts();
            for (Product p : productList) {
                p.removeCategory();
            }
        }
    }

    public void deleteCategory(int id) {
        removeProductsList(id);
        categoryRepo.deleteById(id);
    }

    public void deleteCategory(String name) {
        Optional<Category> c = categoryRepo.findByCategoryName(name);
        if(c.isPresent()) {
            removeProductsList(c.get().getCategoryID());
            categoryRepo.deleteByCategoryName(name);
        }
    }
}
