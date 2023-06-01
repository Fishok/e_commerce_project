package com.project.domain.entity;



import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class User {


		@Id
		private String uuid;
		@Setter
		private String username;
		@Setter
		private String password;
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
		

}