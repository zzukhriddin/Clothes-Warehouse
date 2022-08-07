package com.sigma.clotheswarehouse.payload;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class OutcomeMaterialGetDTO {

    private UUID id;

    private String productName;

    private String productMeasurementName;

    private String productCategoryName;

    private double productAmount;

    private double totalProductPrice;

    private List<ResourceForOutcomeMaterialGetDTO> materials;

}
