package com.capstone3.api.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Transactional
@Getter @Setter
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int productID;
    private BigDecimal price;
    private String title;
    private int serialNumber;
    @Column(name = "img_URL_1")
    private String imgURL1;
    @Column(name = "img_URL_2")
    private String imgURL2;
    @Column(name = "img_URL_3")
    private String imgURL3;
    @Column(name = "img_URL_4")
    private String imgURL4;
    @Column(name = "img_URL_5")
    private String imgURL5;
    @Column(length = 100000)
    private String details;
    private int quantity;

    @ManyToOne(targetEntity = Category.class)
//    @JoinColumn(name = "category_id")
    private Category category;

    public void addCategory(Category category) {
        this.category = category;
        category.getProducts().add(this);
    }

    public void removeCategory() {
        this.category = null;
    }



}
