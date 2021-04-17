package com.capstone3.api.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "product")
@Getter @Setter
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
    private String details;
    private int quantity;

    @ManyToOne(targetEntity = Category.class)
    private Category category;



}
