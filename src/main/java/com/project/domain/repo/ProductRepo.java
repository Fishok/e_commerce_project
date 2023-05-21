package com.project.domain.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.domain.entity.Product;

import java.util.List;
import java.util.Optional;


@Repository
public interface ProductRepo extends JpaRepository<Product, String> {

    
	 Optional<Product> findById(String productId);

	    List<Product> findAll();

	    List<Product> findAllByCollection(String nameCollection);

	    List<Product> findAllByBrand(String nameBrand);

	    List<Product> findAllByType(String type);
}