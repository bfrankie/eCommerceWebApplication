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

}
