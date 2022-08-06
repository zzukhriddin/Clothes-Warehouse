package com.sigma.clotheswarehouse.payload;

import lombok.Data;

import java.util.List;

@Data
public class OutcomeMaterialPostDTO {

    private List<ResourceForOutcomeMaterialDTO> materials;

    private ProductPostDTO productPostDTO;

    private double amount;
}
