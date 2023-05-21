package com.project.domain.entity;

import java.util.HashMap;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "carts")
@NoArgsConstructor
@Getter
@EqualsAndHashCode
@ToString

public class Cart {
	@Id
	private String uuid;
	@Setter
	private HashMap<String, Integer> products;
	public Cart(String uuid, HashMap<String, Integer> products) {
		super();
		this.uuid = uuid;
		this.products = new HashMap<>();
	}

}