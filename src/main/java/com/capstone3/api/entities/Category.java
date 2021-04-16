package com.capstone3.api.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private int categoryID;
    private String categoryName;

    @OneToMany(targetEntity = Product.class, mappedBy = "category")
    private List<Product> products;


}
