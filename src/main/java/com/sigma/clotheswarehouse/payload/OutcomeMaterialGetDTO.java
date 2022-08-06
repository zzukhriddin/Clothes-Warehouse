package com.sigma.clotheswarehouse.payload;

import lombok.Data;

import java.util.List;

@Data
public class OutcomeMaterialGetDTO {

    private String productName;

    private String productMeasurementName;

    private String productCategoryName;

    private double productAmount;

    private double totalProductPrice;

    private List<ResourceForOutcomeMaterialDTO> materials;

}
