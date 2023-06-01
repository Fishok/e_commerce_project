package com.project.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.codeReturn.Codes;
import com.project.domain.entity.*;
import com.project.domain.repo.*;
import com.project.dto.*;


@Service
public class ProductImpl implements ProductInterface {

    private final ProductRepo productRepo;

    @Autowired
    public ProductImpl(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public Codes addProduct(ProductDTO productDTO) {
        Product product = convertToProductEntity(productDTO);
        productRepo.save(product);
        return Codes.OK;
    }

    @Override
    public Product getProductById(String productId) {
        return productRepo.findById(productId).orElseThrow(() ->
                new IllegalArgumentException("Product with ID " + productId + " not found."));
    }

    @Override
    public Codes setProductPrice(String productId, double price) {
        Product product = getProductById(productId);
        product.setPrice(price);
        productRepo.save(product);
        return Codes.OK;
    }

    @Override
    public Codes setProductDiscount(String productId, int discount) {
        Product product = getProductById(productId);
        product.setDiscount(discount);
        productRepo.save(product);
        return Codes.OK;
    }

    @Override
    public Codes setProductAmount(String productId, int amount) {
        Product product = getProductById(productId);
        product.setAmount(amount);
        productRepo.save(product);
        return Codes.OK;
    }

    @Override
    public Codes removeProduct(String productId) {
        Product product = getProductById(productId);
        productRepo.delete(product);
        return Codes.OK;
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        List<Product> productList = productRepo.findAll();
        return convertToProductDTOList(productList);
    }

    @Override
    public List<ProductDTO> getAllProductsByCollection(String nameCollection) {
        List<Product> productList = productRepo.findAllByCollection(nameCollection);
        return convertToProductDTOList(productList);
    }

    @Override
    public List<ProductDTO> getAllProductsByBrand(String nameBrand) {
        List<Product> productList = productRepo.findAllByBrand(nameBrand);
        return convertToProductDTOList(productList);
    }

    @Override
    public List<ProductDTO> getAllProductsByType(String type) {
        List<Product> productList = productRepo.findAllByType(type);
        return convertToProductDTOList(productList);
    }

    private Product convertToProductEntity(ProductDTO productDTO) {
        Product product = new Product();
        product.setProductId(productDTO.getProductId());
        product.setPrice(productDTO.getPrice());
        product.setAddDate(productDTO.getAddDate());
        product.setType(productDTO.getType());
        product.setBrand(convertToBrandEntity(productDTO.getBrand()));
        product.setCategory(productDTO.getCategory());
        product.setDiscount(productDTO.getDiscount());
        product.setSize(productDTO.getSize());
        product.setAmount(productDTO.getAmount());
        return product;
    }

    private Brand convertToBrandEntity(BrandDTO brandDTO) {
        Brand brand = new Brand();
        brand.setNameBrand(brandDTO.getNameBrand());
       
        brand.setNameCollection(brandDTO.getNameCollection());
        return brand;
    }

    private List<ProductDTO> convertToProductDTOList(List<Product> productList) {
        List<ProductDTO> productDTOList = new ArrayList<>();
        for (Product product : productList) {
            ProductDTO productDTO = new ProductDTO();
            productDTO.setProductId(product.getProductId());
            productDTO.setPrice(product.getPrice());
            productDTO.setAddDate(product.getAddDate());
            productDTO.setType(product.getType());
            productDTO.setBrand(convertToBrandDTO(product.getBrand()));
            productDTO.setCategory(product.getCategory());
            productDTO.setDiscount(product.getDiscount());
            productDTO.setSize(product.getSize());
            productDTO.setAmount(product.getAmount());
            productDTOList.add(productDTO);
        }
        return productDTOList;
    }

    private BrandDTO convertToBrandDTO(Brand brand) {
        BrandDTO brandDTO = new BrandDTO();
        brandDTO.setNameBrand(brand.getNameBrand());
        
        brandDTO.setNameCollection(brand.getNameCollection());
        return brandDTO;
    }
}
