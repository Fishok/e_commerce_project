package com.project.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.project.codeReturn.Codes;
import com.project.domain.entity.Product;
import com.project.dto.ProductDTO;

public interface ProductInterface {
	Codes addProduct(ProductDTO product);

Product getProductById(String productId);

Codes setProductPrice(String productId, double price);

Codes setProductDiscount(String productId, int discount);

Codes setProductAmount(String productId, int amount);

Codes removeProduct(String productId);

List<ProductDTO> getAllProducts();

List<ProductDTO> getAllProductsByCollection(String nameCollection);

List<ProductDTO> getAllProductsByBrand(String nameBrand);

List<ProductDTO> getAllProductsByType(String type);



}
