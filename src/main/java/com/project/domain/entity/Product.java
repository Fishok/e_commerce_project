package com.project.domain.entity;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "products")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {

	@Id
	private String productId;
	private double price;
	private LocalDate addDate;
	private String type;
	private Brand brand;
	private String category;
	private String size;
	@Setter
	private int discount;
	@Setter
	private int amount;

}
