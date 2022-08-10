package com.sigma.clotheswarehouse.payload;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    @NotNull
    private String name;

    private String model;

    private String code;

    private double price;

    private double amount;

    private Long measurementId;

    private Long categoryId;

    private boolean deleted;
}

