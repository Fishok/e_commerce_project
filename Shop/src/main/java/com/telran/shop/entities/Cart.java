package com.telran.shop.entities;

import java.util.HashMap;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@Getter
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
	@Override
	public int hashCode() {
		return Objects.hash(uuid);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cart other = (Cart) obj;
		return Objects.equals(uuid, other.uuid);
	}
	
	

}
