package com.project.domain.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "cillections")
@NoArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class Collection {
	@Id
	private String nameCollection;
	@Setter
	private List<String> products;
	public Collection(String nameCollection, List<String> products) {
		super();
		this.nameCollection = nameCollection;
		this.products = new ArrayList<>();
	}
	
}
