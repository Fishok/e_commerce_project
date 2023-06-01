package com.project.controllers;

import com.project.codeReturn.Codes;
import com.project.domain.entity.Brand;
import com.project.dto.BrandDTO;
import com.project.service.BrandInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.project.api.ApiConstants.*;


@RestController
public class BrandController {

    @Autowired
    BrandInterface service;


  

    @GetMapping(value = GET_Brand)
    public BrandDTO getBrandByName(@RequestParam String nameBrand) {
        return service.getBrandByName(nameBrand);
    }

    @PostMapping(value = ADD_Brand)
    public Codes addBrand(@RequestParam String nameBrand) {
        return service.addBrand(nameBrand);
    }

    @DeleteMapping(value = REMOVE_Brand)
    public Codes removeBrand (@RequestParam String nameBrand) {
        return service.removeBrand(nameBrand);
    }
}
