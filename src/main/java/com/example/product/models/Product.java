package com.example.product.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "products")
public class Product {
    @Id
    private String id;
    private String name;
    private Double price;
    private String description;
    private Long stock;

    public Product(String id, String name, Double price, String description, Long stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.stock = stock;
    }
}
