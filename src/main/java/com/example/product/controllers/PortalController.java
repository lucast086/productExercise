package com.example.product.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class PortalController {

    @GetMapping(value = "")
    public String instructions(){
        System.out.println("""
        *********************************************
        System.out.println("YOU CAN GENERATE JSON IN THE FOLLOWING WEB");
        System.out.println("https://www.site24x7.com/es/tools/generador-de-json.html""");

        System.out.println("*");
        System.out.println("USE THIS TEMPLATE TO GENERATE ProductDTO ");

        System.out.println("""
                {
                   "name": "string('Bus','Car','Bike')",
                   "price": "int(100-350)",
                   "description": "string",
                   "stock": "int(0-10)"
                }
                """);

        System.out.println("**************************************************************");
        System.out.println("ENDPOINTS");
        System.out.println("""
                --------------------------------------------------------------------------
                GET   : /products/{id} - obtener un productoDTO por id
                GET   : /products/ - obtener una lista de productoDTO
                
                POST  : /products      - crear un productoDTO
                PUT   : /products/{id} - actualizar un productoDTO por id
                DELETE: /products/{id} - eliminar un productoDTO por id
                --------------------------------------------------------------------------
                """);
        return "instructions.html";
    }

}
