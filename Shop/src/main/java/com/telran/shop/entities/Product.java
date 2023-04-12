package com.telran.shop.entities;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product {
	@Id
	private String productId;
	@Setter
	private double price;
	private LocalDate addDate;
	private String type;
	private String nameCollection;
	private String nameBrand;
	private String category;
	private String size;
	@Setter
	private int discount;
	@Setter
	private int amount;
	@Override
	public int hashCode() {
		return Objects.hash(productId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(productId, other.productId);
	}

	
}
