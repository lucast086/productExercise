package com.example.product.services;

import com.example.product.exceptions.MyException;
import com.example.product.models.Product;

import java.util.List;

public interface ProductService {
    void saveProduct(Product product);

    void deleteProductById(String id) throws MyException;

    List<Product> findAll();

    Product findById(String id) throws MyException;

    void updateProduct(Product product) throws MyException;
}
