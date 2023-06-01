package com.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
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
