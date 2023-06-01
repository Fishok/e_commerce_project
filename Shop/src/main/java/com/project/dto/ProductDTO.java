package com.project.dto;


import lombok.Data;

import lombok.NoArgsConstructor;


import java.io.Serializable;
import java.time.LocalDate;


@NoArgsConstructor

@Data
@SuppressWarnings("serial")
public class ProductDTO implements Serializable {

    String productId;
    private double price;
    private LocalDate addDate;
    private String type;
    private BrandDTO brand;
    private String category;
    private int discount;
    private String size;
    private int amount;

}
