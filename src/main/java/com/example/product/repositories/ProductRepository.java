package com.example.product.repositories;

import com.example.product.models.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProductRepository extends MongoRepository<Product, String> {

/*    Product findByName(String name);

    List<Product> findAllByOrderByName();*/
}
