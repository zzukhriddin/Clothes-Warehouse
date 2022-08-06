package com.sigma.clotheswarehouse.payload;

import lombok.Data;

import java.util.UUID;

@Data
public class ResourceForOutcomeMaterialDTO {

    private UUID materialId;

    private double materialAmount;
}
