package com.example.product.services;

import com.example.product.models.Product;
import com.example.product.models.dto.ProductDTO;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Service
public class DTOmapper {

    public static Product toProduct(String id, ProductDTO productDTO){
        return new Product(
                id,
                productDTO.name(),
                productDTO.price(),
                productDTO.description(),
                productDTO.stock()
        );
    }

    public static ProductDTO toProductDTO(Product product){

        return new ProductDTO(
                product.getName(),
                product.getPrice(),
                product.getDescription(),
                product.getStock()
        );
    }

    public static List<ProductDTO> toProductDTOList(List<Product> productList){
        List<ProductDTO> productDTOList = new ArrayList<>();
        for (Product product : productList) {
            productDTOList.add(toProductDTO(product));
        }
        return productDTOList;
    }

}
