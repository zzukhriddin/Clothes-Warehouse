package com.sigma.clotheswarehouse.payload;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class IncomeMaterialDTO {

    private MaterialDTO materialDTO;

    private Timestamp incomeDate;

    private Double amount;

    private Double price;

    private MeasurementDTO measurementDTO;
}
