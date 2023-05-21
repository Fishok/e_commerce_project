package com.project.domain.entity;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "products")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode
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
		
}
