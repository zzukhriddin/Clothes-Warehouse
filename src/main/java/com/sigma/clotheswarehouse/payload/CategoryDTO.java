package com.sigma.clotheswarehouse.payload;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CategoryDTO {

    @NotBlank(message = "categoryName field must not be empty!")
    private String name;

}
