package com.sigma.clotheswarehouse.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductPostDTO {

    @NotBlank(message = "productName field must not be empty!")
    private String name;

    private double price;

    private double amount;

    private MeasurementDTO measurementDTO;

    private CategoryDTO categoryDTO;

}

