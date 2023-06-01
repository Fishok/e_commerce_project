package com.project.dto;


import java.util.List;

import com.project.codeReturn.Codes;


import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor

@Data
public class OrderDto {
    private String userId;
    List<ProductDTO> products;
    private Codes status;
	
}
