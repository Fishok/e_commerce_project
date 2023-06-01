package com.project.domain.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.domain.entity.*;



@Repository
public interface CartRepo extends JpaRepository<Cart, Long> {
	
	
	Cart getCartByUserId( String uuid);

	
	
	String addProductToCart( String cartId,  String productId);

	
	
	String removeProductFromCart( String uuid,  String productId);

	
	int setAmountOfProductFromCart( String uuid, String productId,  Integer amount);
}