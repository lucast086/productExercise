package com.example.product.services;

import com.example.product.exceptions.MyException;
import com.example.product.models.Product;
import com.example.product.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Override
    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public void updateProduct(Product product) throws MyException {
        if (!productRepository.existsById(product.getId())) throw new MyException("Id not exist");
        productRepository.save(product);
    }

    @Override
    public void deleteProductById(String id) throws MyException {
        if (!productRepository.existsById(id)) throw new MyException("Id not exist");
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(String id) throws MyException {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isEmpty()) throw new MyException("Id not exist");
        return optionalProduct.get();
    }


}
