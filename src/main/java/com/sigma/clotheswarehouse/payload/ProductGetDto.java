package com.sigma.clotheswarehouse.payload;

import com.sigma.clotheswarehouse.entity.Measurement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductGetDto {
    private UUID id;

    private String name;

    private double price;

    private double amount;

    private MeasurementDTO measurementDTO;

    private CategoryDTO categoryDTO;

    private boolean deleted;
}
