package com.sigma.clotheswarehouse.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientGetDto {
    private Long id;
    private String fio;
    private String phoneNumber;
    private String address;
    private boolean deleted;
}
