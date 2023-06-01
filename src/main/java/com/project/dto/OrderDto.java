package com.project.dto;

import java.util.HashMap;
import java.util.List;

import com.project.codeReturn.Codes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderDto {
    private String userId;
    List<ProductDTO> products;
    private Codes status;
	
}
