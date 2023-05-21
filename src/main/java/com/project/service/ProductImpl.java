package com.project.service;

import java.time.LocalDate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.domain.entity.*;
import com.project.domain.repo.ProductRepo;



@Service
public class ProductImpl implements ProductInterface {

	 private final ProductRepo productRepo;

	    @Autowired
	    public ProductImpl(ProductRepo productRepo) {
	        this.productRepo = productRepo;
	    }

   

    @Override
    public Product addProduct(String productId, double price, LocalDate addDate,String type, String nameCollection, String nameBrand,
                              String size, String category, int discount, int amount) {
       

        Product product = new Product(productId, price,addDate, type, nameBrand, nameCollection, size, category, discount, amount);

        return productRepo.save(product);
    }

    @Override
    public Product getProductById(String productId) {
        return productRepo.findById(productId).orElseThrow(() ->
                new IllegalArgumentException("Product with ID " + productId + " not found."));
    }

    @Override
    public double setProductPrice(String productId, double price) {
    	Product product = getProductById(productId);
        product.setPrice(price);
        productRepo.save(product);
        return product.getPrice();
    }

    @Override
    public int setProductDiscount(String productId, int discount) {
    	Product product = getProductById(productId);
        product.setDiscount(discount);
        productRepo.save(product);
        return product.getDiscount();
    }

    @Override
    public int setProductAmount(String productId, int amount) {
    	 Product product = getProductById(productId);
         product.setAmount(amount);
         productRepo.save(product);
         return product.getAmount();
    }

    @Override
    public String removeProduct(String productId) {
    	Product product = getProductById(productId);
        productRepo.delete(product);
        return "Product with ID " + productId + " has been removed";
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    @Override
    public List<Product> getAllProductsByCollection(String nameCollection) {
        return productRepo.findAllByCollection(nameCollection);
    }

    @Override
    public List<Product> getAllProductsByBrand(String nameBrand) {
        return productRepo.findAllByBrand(nameBrand);
    }

    @Override
    public List<Product> getAllProductsByType(String type) {
        return productRepo.findAllByType(type);
    }
}