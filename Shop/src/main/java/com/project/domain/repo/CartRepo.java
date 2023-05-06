package com.project.domain.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import com.project.domain.entity.*;

import jakarta.transaction.Transactional;

@Repository
public interface CartRepo extends JpaRepository<Cart, Long> {
	
	@Query("SELECT c FROM Cart c WHERE c.user.uuid = :uuid")
	Cart getCartByUserId(@Param("uuid") String uuid);

	@Modifying
	@Query(value = "INSERT INTO cart_products(cart_id, product_id) VALUES (:cartId, :productId)", nativeQuery = true)
	@Transactional
	String addProductToCart(@Param("cartId") String cartId, @Param("productId") String productId);

	@Modifying
	@Query(value = "DELETE FROM cart_products WHERE cart_id = :cartId AND product_id = :productId", nativeQuery = true)
	@Transactional
	String removeProductFromCart(@Param("cartId") String uuid, @Param("productId") String productId);

	@Modifying
	@Query(value = "UPDATE cart_products SET amount = :amount WHERE cart_id = :cartId AND product_id = :productId", nativeQuery = true)
	@Transactional
	int setAmountOfProductFromCart(@Param("cartId") String uuid, @Param("productId") String productId, @Param("amount") Integer amount);
}