package com.example.product.controllers;

import com.example.product.exceptions.MyException;
import com.example.product.models.dto.ProductDTO;
import com.example.product.services.DTOmapper;
import com.example.product.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    //crear
    @PostMapping(value = "")
    public ResponseEntity<ProductDTO> saveProduct(@RequestBody ProductDTO productDTO){
        productService.saveProduct(DTOmapper.toProduct(null,productDTO));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //actualizar
    @PutMapping(value = "/{id}")
    public ResponseEntity<ProductDTO>  updateProduct(@PathVariable String id, @RequestBody ProductDTO productDTO){
        try {
            productService.updateProduct(DTOmapper.toProduct(id,productDTO));
        } catch (MyException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //borrar
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<ProductDTO>  deleteProduct(@PathVariable String id){
        try {
            productService.deleteProductById(id);
        } catch (MyException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //listarTodos
    @GetMapping(value = "")
    public ResponseEntity<List<ProductDTO>> findAll(){
        return new ResponseEntity<>(DTOmapper.toProductDTOList(productService.findAll()),HttpStatus.OK);
    }

    //obtener1
    @GetMapping(value = "/{id}")
    public ResponseEntity<ProductDTO> findById(@PathVariable String id){
        ProductDTO productDTO;
        try {
            productDTO = DTOmapper.toProductDTO(productService.findById(id));
        } catch (MyException e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(productDTO);
    }

}
