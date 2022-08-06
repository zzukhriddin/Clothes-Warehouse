package com.sigma.clotheswarehouse.payload;

import javax.validation.constraints.NotBlank;

public class CategoryDTO {

    @NotBlank(message = "categoryName field must not be empty!")
    private String name;

}
