package com.sigma.clotheswarehouse.payload;

import com.sigma.clotheswarehouse.entity.Measurement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductGetDto {
    private String name;

    private double price;

    private double amount;

    private MeasurementDTO measurementDTO;

    private boolean deleted;
}
