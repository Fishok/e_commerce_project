package com.telran.shop.entities;

import java.util.ArrayList;
import java.util.List;
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
public class Collect {
	@Id
	private String nameCollection;
	@Setter
	private List<String> products;
	public Collect(String nameCollection, List<String> products) {
		super();
		this.nameCollection = nameCollection;
		this.products = new ArrayList<>();
	}
	@Override
	public int hashCode() {
		return Objects.hash(nameCollection);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Collect other = (Collect) obj;
		return Objects.equals(nameCollection, other.nameCollection);
	}

	
}
