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

	@Override
	public int hashCode() {
		return Objects.hash(nameBrand);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Brand other = (Brand) obj;
		return Objects.equals(nameBrand, other.nameBrand);
	}

}
