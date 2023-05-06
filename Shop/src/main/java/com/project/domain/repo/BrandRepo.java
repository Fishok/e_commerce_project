package com.project.domain.repo;

import org.springframework.data.repository.query.*;


import java.util.Optional;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import com.project.domain.entity.Brand;

@Repository
public interface BrandRepo extends JpaRepository<Brand, Long> {

	Optional<Brand> findByNameBrand(String nameBrand);

	@Modifying
	@Query(value = "INSERT INTO Brand(name) VALUES (:name)", nativeQuery = true)
	Brand addBrand(@Param("nameBrand") String nameBrand);

	@Modifying
	@Query("DELETE FROM Brand WHERE nameBrand = :nameBrand")
	String removeBrand(String nameBrand);

	
}
