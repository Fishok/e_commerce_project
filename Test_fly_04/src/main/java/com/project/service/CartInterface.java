package com.project.service;

import com.project.domain.entity.Cart;

public interface CartInterface {
	Cart getCartByUserId(String uuid);


    String addProductToCart(String uuid, String productId);

    String removeProductFromCart(String uuid, String productId);

    int setAmountOfProductFromCart(String uuid, String productId, Integer amount);
}
