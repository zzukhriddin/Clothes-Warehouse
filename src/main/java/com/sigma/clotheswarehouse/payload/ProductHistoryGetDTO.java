package com.sigma.clotheswarehouse.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductHistoryGetDTO {
    private ProductGetDto productGetDto;

    private double price;

    private double amount;

    private ClientGetDto clientGetDto;
}
