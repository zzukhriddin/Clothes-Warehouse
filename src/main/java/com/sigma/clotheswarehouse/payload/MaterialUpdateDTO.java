package com.sigma.clotheswarehouse.payload;

import lombok.Data;

@Data
public class MaterialUpdateDTO {

    private String materialName;

    private String measurementName;

    private double amount;

    private double price;

    private boolean deleted;
}
