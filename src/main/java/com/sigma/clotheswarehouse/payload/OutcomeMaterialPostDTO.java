package com.sigma.clotheswarehouse.payload;

import lombok.Data;

@Data
public class OutcomeMaterialPostDTO {

    private MaterialPostDTO materialPostDTO;

    private ProductDTO productDTO;

    private double amount;
}
