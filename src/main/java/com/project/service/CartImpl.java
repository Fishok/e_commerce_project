package com.project.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import com.project.domain.entity.*;

import com.project.domain.repo.*;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CartImpl implements CartInterface{
	
	
	private final CartRepo cartRepo;

	@Autowired
	public CartImpl(CartRepo cartRepo) {
	    this.cartRepo = cartRepo;
	}

	@Override
	public Cart getCartByUserId(String uuid) {
	    return cartRepo.getCartByUserId(uuid);
	}

	@Override
	public String addProductToCart(String uuid, String productId) {
	    Cart cart = getCartByUserId(uuid);

	    if (cart == null) {
	        cart = new Cart(uuid, new HashMap<>());
	        cart = cartRepo.save(cart);
	    }

	    if (cart.getProducts().containsKey(productId)) {
	        return "Product already exists in the cart.";
	    }

	    cart.getProducts().put(productId, 1);
	    cartRepo.addProductToCart(cart.getUuid(), productId);
	    return "Product added to cart successfully.";
	}

	@Override
	public String removeProductFromCart(String uuid, String productId) {
	    Cart cart = getCartByUserId(uuid);

	    if (cart == null || !cart.getProducts().containsKey(productId)) {
	        return "Product does not exist in the cart.";
	    }

	    cart.getProducts().remove(productId);
	    cartRepo.removeProductFromCart(cart.getUuid(), productId);
	    return "Product removed from cart successfully.";
	}

	@Override
	public int setAmountOfProductFromCart(String uuid, String productId, Integer amount) {
	    Cart cart = getCartByUserId(uuid);

	    if (cart == null || !cart.getProducts().containsKey(productId)) {
	        return 0;
	    }

	    cart.getProducts().put(productId, amount);
	    return cartRepo.setAmountOfProductFromCart(cart.getUuid(), productId, amount);
	}
    }