package com.project.dto;


import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@Data

@NoArgsConstructor
public class CartDTO {
	String uuid;
	List<ProductDTO> products;
	int amount;

}
