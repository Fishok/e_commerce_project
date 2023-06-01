package com.project.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import com.project.codeReturn.Codes;
import com.project.domain.entity.*;

import com.project.domain.repo.*;
import com.project.dto.*;


import jakarta.transaction.Transactional;

@Service
@Transactional
public class CartImpl implements CartInterface{
	

	
	private final CartRepo cartRepo;
	private final ProductRepo productRepo;
	
	@Autowired
	public CartImpl(CartRepo cartRepo, ProductRepo productRepo) {
        this.cartRepo = cartRepo;
        this.productRepo = productRepo;
    }

	@Override
	public CartDTO getCartByUserId(String uuid) {
        Cart cart = cartRepo.getCartByUserId(uuid);
        return convertToCartDTO(cart);
    }
	

	public CartDTO convertToCartDTO(Cart cart) {
		 CartDTO cartDTO = new CartDTO();
	        cartDTO.setUuid(cart.getUuid());
	        cartDTO.setProducts(convertProductMapToProductDTOList(cart.getProducts()));
	        cartDTO.setAmount(calculateCartAmount(cart.getProducts()));
	        return cartDTO;
	    }

	private List<ProductDTO> convertProductMapToProductDTOList(HashMap<String, Integer> products) {
		List<ProductDTO> productDTOList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : products.entrySet()) {
            String productId = entry.getKey();
            int quantity = entry.getValue();
            ProductDTO productDTO = convertToProductDTO(productId, quantity);
            productDTOList.add(productDTO);
        }
        return productDTOList;
    }
	private int calculateCartAmount(HashMap<String, Integer> products) {
	    int amount = 0;
	    for (int quantity : products.values()) {
	        amount += quantity;
	    }
	    return amount;
	}


	private ProductDTO convertToProductDTO(String productId, int quantity) {
        Product product = productRepo.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("Product with id " + productId + " not found"));

        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductId(productId);
        productDTO.setPrice(product.getPrice());
        productDTO.setAddDate(product.getAddDate());
        productDTO.setType(product.getType());
        productDTO.setBrand(convertToBrandDTO(product.getBrand()));
        productDTO.setCategory(product.getCategory());
        productDTO.setDiscount(product.getDiscount());
        productDTO.setSize(product.getSize());
        productDTO.setAmount(quantity);

        return productDTO;
    }

	private BrandDTO convertToBrandDTO(Brand brand) {
	    BrandDTO brandDTO = new BrandDTO();
	    brandDTO.setNameBrand(brand.getNameBrand());
	    
	    brandDTO.setNameCollection(brand.getNameCollection());
	    return brandDTO;
	}

	@Override
	public Codes addProductToCart(String uuid, String productId) {
        Cart cart = cartRepo.getCartByUserId(uuid);
        if (cart == null) {
            cart = new Cart(uuid, new HashMap<>());
        }
        if (cart.getProducts().containsKey(productId)) {
            return Codes.WRONG;
        }
        cart.getProducts().put(productId, 1);
        cartRepo.save(cart);
        return Codes.OK;
    }
	
	@Override
	public Codes removeProductFromCart(String uuid, String productId) {
        Cart cart = cartRepo.getCartByUserId(uuid);
        if (cart == null || !cart.getProducts().containsKey(productId)) {
            return Codes.WRONG;
        }
        cart.getProducts().remove(productId);
        cartRepo.save(cart);
        return Codes.OK;
    }

	@Override
	public Codes setAmountOfProductFromCart(String uuid, String productId, Integer amount) {
		Cart cart = cartRepo.getCartByUserId(uuid);
	    if (cart == null || !cart.getProducts().containsKey(productId)) {
	        return Codes.WRONG;
	    }
	    cart.getProducts().put(productId, amount);
	    cartRepo.save(cart);
	    return Codes.OK;
	}

    }