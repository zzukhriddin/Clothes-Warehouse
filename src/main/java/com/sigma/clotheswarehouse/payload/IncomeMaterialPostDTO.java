package com.sigma.clotheswarehouse.payload;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class IncomeMaterialPostDTO {

    private MaterialPostDTO materialPostDTO;

    private Timestamp incomeDate;

    private double amount;

    private double price;

    private MeasurementDTO measurementDTO;
}
