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
	
	
	private BrandRepo brandRepo;
	@Autowired
	 public BrandImpl(BrandRepo brandRepo) {
        this.brandRepo = brandRepo;
    }
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
	public boolean removeBrand(String nameBrand) {
		 Brand brand = brandRepo.findByNameBrand(nameBrand).orElse(null);
	        if (brand != null) {
	            brandRepo.delete(brand);
	            return true;
	        }
	        return false;
	}

	@Override
	public Brand getBrandById(Long id) {
		 return brandRepo.findById(id)
		            .orElseThrow(() -> new IllegalArgumentException("Brand with id " + id + " does not exist"));
	}

	@Override
	public Brand getBrandByName(String nameBrand) {
		return brandRepo.findByNameBrand(nameBrand)
	            .orElseThrow(() -> new IllegalArgumentException("Brand with name " + nameBrand + " not found"));
	}
}
