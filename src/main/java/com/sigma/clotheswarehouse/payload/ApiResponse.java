package com.sigma.clotheswarehouse.payload;

import lombok.Data;

@Data
public class ApiResponse {

    private boolean success;

    private String message;

    private Object data;

    public ApiResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }
}