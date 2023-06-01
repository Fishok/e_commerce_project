package com.project.domain.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "brands")
@NoArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class Brand {
	@Id
	private String nameBrand;
	
	@Setter
	private List<String> nameCollection;

	public Brand(String nameBrand, List<String> nameCollection) {
		super();
		this.nameBrand = nameBrand;
		this.nameCollection = new ArrayList<>();
		
	}

	public void setNameBrand(String nameBrand2) {
		// TODO Auto-generated method stub
		
	}

	public void setId(Long id2) {
		// TODO Auto-generated method stub
		
	}

}