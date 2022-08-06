package com.sigma.clotheswarehouse.payload;

import lombok.Data;


@Data
public class ResourceForOutcomeMaterialGetDTO {

    private String materialName;

    private String measurementName;

    private double materialAmount;
}
