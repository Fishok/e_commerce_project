package com.telran.shop.entities;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class User {
	@Id
	private String uuid;
	@Setter
	private String passwordHashCode;
	@Setter
	private String role;
	@Setter
	private String firstName;
	@Setter
	private String secondName;
	@Setter
	private String email;
	@Setter
	private String phoneNumber;
	@Setter
	private String country;
	@Setter
	private String address;
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
		User other = (User) obj;
		return Objects.equals(uuid, other.uuid);
	}

	
}
