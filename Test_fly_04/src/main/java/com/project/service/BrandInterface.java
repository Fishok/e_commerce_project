package com.project.service;

import com.project.domain.entity.Brand;

public interface BrandInterface {
	Brand getBrandById(Long id);

	Brand getBrandByName(String nameBrand);

	Brand addBrand(String nameBrand);

	boolean removeBrand(String nameBrand);
}
