package com.sigma.clotheswarehouse.payload;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class OutcomeMaterialPostDTO {

    private List<ResourceForOutcomeMaterialDTO> resources;

    private UUID productId;

    private double productPrice;

    private double productAmount;
}
