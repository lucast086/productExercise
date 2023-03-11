package com.example.product.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class PortalController {

    @GetMapping(value = "")
    public String instructions(){

        return """
                                
                *********************************************
                YOU CAN GENERATE JSON IN THE FOLLOWING WEB
                https://www.site24x7.com/es/tools/generador-de-json.html
                                
                USE THIS TEMPLATE TO GENERATE ProductDTO
                                
                {
                "name": "string('Bus','Car','Bike')",
                "price": "int(100-350)",
                "description": "string",
                "stock": "int(0-10)"
                }
                                
                                
                **************************************************************
                ENDPOINTS
                                
                --------------------------------------------------------------------------
                GET   : /products/{id} - obtener un productoDTO por id
                GET   : /products/ - obtener una lista de productoDTO
                                
                POST  : /products      - crear un productoDTO
                PUT   : /products/{id} - actualizar un productoDTO por id
                DELETE: /products/{id} - eliminar un productoDTO por id
                --------------------------------------------------------------------------
                """;
    }
}
