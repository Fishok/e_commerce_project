package com.project.controllers;

import com.project.codeReturn.Codes;
import com.project.domain.entity.Product;
import com.project.dto.ProductDTO;
import com.project.service.ProductInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

import static com.project.api.ApiConstants.*;

@RestController
public class ProductController {

    @Autowired
    ProductInterface service;

    @PostMapping(value = ADD_Product)
    public Codes addProduct(@RequestBody ProductDTO product) {
        return service.addProduct(product);
    }

    @GetMapping(value = GET_ProductById)
    public Product getProductById(@RequestParam String productId) {
        return service.getProductById(productId);
    }

    @PostMapping(value = SET_ProductPrice)
    public Codes setProductPrice(@RequestParam String productId,@RequestParam double price) {
        return service.setProductPrice(productId,price);
    }

    @PostMapping(value = Set_ProductDiscount)
    public Codes setProductDiscount(@RequestParam String productId,@RequestParam int discount) {
        return service.setProductDiscount(productId,discount);
    }

    @PostMapping(value = SET_ProductAmount)
    public Codes setProductAmount(@RequestParam String productId,@RequestParam int amount) {
        return service.setProductAmount(productId,amount);
    }

    @DeleteMapping(value = DELETE_Product)
    public Codes removeProduct(@RequestParam String productId) {
        return service.removeProduct(productId);
    }

    @GetMapping(value = GET_AllProducts)
    public List<ProductDTO> getAllProducts() {
        return service.getAllProducts();
    }

    @GetMapping(value = GET_AllProductsByCollection)
    public List<ProductDTO> getAllProductsByCollection(@RequestParam String nameCollection) {
        return service.getAllProductsByCollection(nameCollection);
    }

    @GetMapping(value = GET_AllProductsByBrand)
    public List<ProductDTO> getAllProductsByBrand(@RequestParam String nameBrand) {
        return service.getAllProductsByBrand(nameBrand);
    }

    @GetMapping(value = GET_AllProductsByType)
    public List<ProductDTO> getAllProductsByType(@RequestParam String type) {
        return service.getAllProductsByBrand(type);
    }
}
