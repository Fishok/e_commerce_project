package com.project.domain.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import com.project.domain.entity.*;

@Repository
public interface ProductRepo extends JpaRepository<Product, String> {

    
    @Modifying
    @Query("INSERT INTO Product(productId, price, type, nameCollection, nameBrand, size, category, discount, amount) "
            + "VALUES(:productId, :price, :type, :nameCollection, :nameBrand, :size, :category, :discount, :amount)")
    Product addProduct(@Param("productId") String productId, @Param("price") double price, @Param("type") String type,
                    @Param("nameCollection") String nameCollection, @Param("nameBrand") String nameBrand,
                    @Param("size") String size, @Param("category") String category, @Param("discount") int discount,
                    @Param("amount") int amount);

    
    Optional<Product> findById(String productId);

    
    @Modifying
    @Query("UPDATE Product SET price = :price WHERE productId = :productId")
    double setProductPrice(@Param("productId") String productId, @Param("price") double price);

    
    @Modifying
    @Query("UPDATE Product SET discount = :discount WHERE productId = :productId")
    int setProductDiscount(@Param("productId") String productId, @Param("discount") int discount);

    
    @Modifying
    @Query("UPDATE Product SET amount = :amount WHERE productId = :productId")
    int setProductAmount(@Param("productId") String productId, @Param("amount") int amount);

    
    @Modifying
    @Query("DELETE FROM Product WHERE productId = :productId")
    String removeProduct(@Param("productId") String productId);

    
    List<Product> findAll();

    
    @Query("SELECT p FROM Product p WHERE p.nameCollection = :nameCollection")
    List<Product> findAllByCollection(@Param("nameCollection") String nameCollection);

    
    @Query("SELECT p FROM Product p WHERE p.nameBrand = :nameBrand")
    List<Product> findAllByBrand(@Param("nameBrand") String nameBrand);

    
    @Query("SELECT p FROM Product p WHERE p.type = :type")
    List<Product> findAllByType(@Param("type") String type);
}