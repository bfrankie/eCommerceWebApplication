package com.capstone3.api.entities;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int productID;
    private BigDecimal price;
    private int serialNumber;
    private String imgURL1;
    private String imgURL2;
    private String imgURL3;
    private String imgURL4;
    private String imgURL5;
    private String details;
    private int quantity;


}
