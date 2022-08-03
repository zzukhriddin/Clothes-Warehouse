package com.sigma.clotheswarehouse.payload;

import lombok.Data;

import java.sql.Timestamp;
import java.util.UUID;

@Data
public class IncomeMaterialGetDTO {

    private UUID id;

    private MaterialGetDTO materialGetDTO;

    private Timestamp incomeDate;

    private double amount;

    private double price;

    private MeasurementDTO measurementDTO;
}
