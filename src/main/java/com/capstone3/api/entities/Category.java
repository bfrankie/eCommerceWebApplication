package com.capstone3.api.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter @Setter
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private int categoryID;
    private String categoryName;

    @JsonIgnore
    @OneToMany(targetEntity = Product.class, mappedBy = "category")
    private List<Product> products;

//    @JsonValue
//    public List<String> getNameAndProducts() {
//        List<String> categoryProperties = new ArrayList<>();
//        categoryProperties.add(this.categoryName);
//        for(Product p : products) {
//            categoryProperties.add(p.getTitle());
//        }
//        return categoryProperties;
//    }



}
