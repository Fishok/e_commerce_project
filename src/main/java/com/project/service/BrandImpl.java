package com.project.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.codeReturn.Codes;
import com.project.domain.entity.Brand;
import com.project.domain.repo.BrandRepo;
import com.project.dto.BrandDTO;

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
	public Codes addBrand(String nameBrand) {
	    Optional<Brand> optionalBrand = brandRepo.findByNameBrand(nameBrand);
	    if (optionalBrand.isPresent()) {
	        return Codes.WRONG;
	    }
	    Brand brand = new Brand();
	    brandRepo.save(brand);
	    return Codes.OK;
	}

	@Override
	public Codes removeBrand(String nameBrand) {
		 Brand brand = brandRepo.findByNameBrand(nameBrand).orElse(null);
	        if (brand != null) {
	            brandRepo.delete(brand);
	            return Codes.OK;
	        }
	        return Codes.WRONG;
	}

	@Override
	public BrandDTO getBrandById(Long id) {
	    Brand brand = brandRepo.findById(id)
	            .orElseThrow(() -> new IllegalArgumentException("Brand with id " + id + " does not exist"));

	    return new BrandDTO(brand);
	}

	@Override
	public BrandDTO getBrandByName(String nameBrand) {
	    Brand brand = brandRepo.findByNameBrand(nameBrand)
	            .orElseThrow(() -> new IllegalArgumentException("Brand with name " + nameBrand + " not found"));

	    return new BrandDTO(brand);
	}
}
