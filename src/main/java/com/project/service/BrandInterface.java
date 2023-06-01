package com.project.service;

import com.project.codeReturn.Codes;
import com.project.domain.entity.Brand;
import com.project.dto.BrandDTO;

public interface BrandInterface {
	BrandDTO getBrandById(Long id);

	BrandDTO getBrandByName(String nameBrand);

	Codes addBrand(String nameBrand);

	Codes removeBrand(String nameBrand);
}
