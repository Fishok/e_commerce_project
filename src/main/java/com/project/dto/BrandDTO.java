package com.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

import com.project.domain.entity.Brand;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuppressWarnings("serial")
public class BrandDTO implements Serializable {

    private String nameBrand;
    
    @Setter
	private List<String> nameCollection;
    public BrandDTO(Brand brand) {
        this.nameBrand = brand.getNameBrand();
        
        this.nameCollection = brand.getNameCollection();
    }
}
