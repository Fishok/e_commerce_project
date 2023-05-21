package com.project.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.project.domain.entity.Product;


public interface ProductInterface {
	Product addProduct(String productId, double price, LocalDate addDate,String type, String nameCollection, String nameBrand,
            String size, String category, int discount, int amount);

Product getProductById(String productId);

double setProductPrice(String productId, double price);

int setProductDiscount(String productId, int discount);

int setProductAmount(String productId, int amount);

String removeProduct(String productId);

List<Product> getAllProducts();

List<Product> getAllProductsByCollection(String nameCollection);

List<Product> getAllProductsByBrand(String nameBrand);

List<Product> getAllProductsByType(String type);

}
