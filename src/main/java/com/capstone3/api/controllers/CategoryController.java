package com.capstone3.api.controllers;


import com.capstone3.api.entities.Category;
import com.capstone3.api.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.Optional;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    
    @Autowired
    CategoryService categoryService;

    @GetMapping(path="/all-categories")
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Category> getAllCategories() {
        return categoryService.getCategories();
    }


    @GetMapping(path="/category-by-id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Category> categoryById(@PathVariable int id) {
        return categoryService.getCategoryById(id);
    }

    @GetMapping(path="/category-by-name/{name}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Category> categoryByName(@PathVariable String name) {
        return categoryService.getCategoryByName(name);
    }

    @PostMapping(path = "/create-category")
    @ResponseStatus(HttpStatus.CREATED)
    public Category createCategory(@RequestBody Category c) {
        return categoryService.createCategory(c);
    }

    @PutMapping(path = "/update-category-by-id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Category updateCategoryById(@PathVariable int id, @RequestBody Category c) {
        return categoryService.updateCategory(id, c);
    }

    @DeleteMapping(path = "/delete-category-by-id/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCategoryById(@PathVariable int id) {
        categoryService.deleteCategory(id);
    }

    @Transactional
    @DeleteMapping(path = "/delete-category-by-name/{name}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCategoryByName(@PathVariable String name) {
        categoryService.deleteCategory(name);
    }
}
