package com.project.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.domain.entity.Brand;
import com.project.domain.repo.BrandRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class BrandImpl implements BrandInterface {
	@Autowired
	private BrandRepo brandRepo;

	@Override
	public Brand addBrand(String nameBrand) {
	    Optional<Brand> optionalBrand = brandRepo.findByNameBrand(nameBrand);
	    if (optionalBrand.isPresent()) {
	        throw new IllegalArgumentException("Brand with name " + nameBrand + " already exists");
	    }
	    Brand brand = new Brand(nameBrand, new ArrayList<>());
	    return brandRepo.save(brand);
	}

	@Override
	public String removeBrand(String nameBrand) {
		Optional<Brand> exists = brandRepo.findByNameBrand(nameBrand);
		if (!exists.isPresent()) {
			throw new IllegalArgumentException("Brand with name " + nameBrand + " does not exist");
		}
		brandRepo.removeBrand(nameBrand);
		return "Brand with name " + nameBrand + " has been removed";
	}

	@Override
	public Brand getBrandById(Long id) {
		Optional<Brand> brand = brandRepo.findById(id);
		if (!brand.isPresent()) {
			throw new IllegalArgumentException("Brand with id " + id + " does not exist");
		}
		return brand.get();
	}

	@Override
	public Brand getBrandByName(String nameBrand) {
		Optional<Brand> optionalBrand = brandRepo.findByNameBrand(nameBrand);
		if (optionalBrand.isPresent()) {
			return optionalBrand.get();
		} else {
			throw new IllegalArgumentException("Brand with name " + nameBrand + " not found");
		}

	}
}
