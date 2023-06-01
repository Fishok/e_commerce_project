package com.project.controllers;

import com.project.codeReturn.Codes;
import com.project.domain.entity.Cart;
import com.project.dto.CartDTO;
import com.project.service.CartInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.project.api.ApiConstants.*;


@RestController
public class CartController {

    @Autowired
    CartInterface service;

    @GetMapping(value = GET_CartByUserId)
    public CartDTO getCartByUserId(@RequestParam String uuid) {
        return service.getCartByUserId(uuid);
    }

    @PostMapping(value = ADD_ProductToCart)
    public Codes addProductToCart(@RequestParam String uuid,@RequestParam String productId) {
        return service.addProductToCart(uuid,productId);
    }

    @DeleteMapping(value = REMOVE_ProductFromCart)
    public Codes removeProductFromCart(@RequestParam String uuid,@RequestParam  String productId) {
        return service.removeProductFromCart(uuid, productId);
    }

    @PostMapping(value = SET_AmountOfProductFromCart)
    public Codes setAmountOfProductFromCart(@RequestParam String uuid,@RequestParam  String productId,@RequestParam  Integer amount) {
        return service.setAmountOfProductFromCart(uuid,productId,amount);
   }
}
