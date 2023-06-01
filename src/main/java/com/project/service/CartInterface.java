package com.project.service;

import com.project.codeReturn.Codes;
import com.project.domain.entity.Cart;
import com.project.dto.CartDTO;

public interface CartInterface {
	CartDTO getCartByUserId(String uuid);


    Codes addProductToCart(String uuid, String productId);

    Codes removeProductFromCart(String uuid, String productId);

    Codes setAmountOfProductFromCart(String uuid, String productId, Integer amount);
}
