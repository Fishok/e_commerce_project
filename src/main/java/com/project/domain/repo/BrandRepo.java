package com.project.domain.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.project.domain.entity.Brand;
import java.util.Optional;

import com.project.domain.entity.Brand;


@Repository
public interface BrandRepo extends JpaRepository<Brand, Long> {

	Optional<Brand> findByNameBrand(String nameBrand);

	
	Brand addBrand(String nameBrand);

	
	boolean removeBrand(String nameBrand);

	
}
