package com.sigma.clotheswarehouse.payload;

import lombok.Data;

import java.util.UUID;

@Data
public class MaterialGetDTO {

    private UUID id;

    private String name;

    private double amount;

    private double price;

    private boolean deleted;

    private MeasurementDTO measurementDTO;

}
