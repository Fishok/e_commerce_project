package com.project.domain.entity;


import java.time.LocalDateTime;
import java.util.HashMap;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "carts")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class Order {
	@Id
	private String orderId;
	private String uuid;
	private HashMap<String, Integer> products;
	private LocalDateTime createdDate;
	@Setter
	private LocalDateTime dateExpected;
	@Setter
	private String status;

	

}