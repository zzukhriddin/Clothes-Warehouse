package com.sigma.clotheswarehouse.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductHistoryDTO {
    private UUID productId;

    private double price;

    private double amount;

    private Long clientId;
}
