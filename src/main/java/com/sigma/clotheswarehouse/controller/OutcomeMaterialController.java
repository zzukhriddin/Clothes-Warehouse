package com.sigma.clotheswarehouse.controller;

import com.sigma.clotheswarehouse.payload.ApiResponse;
import com.sigma.clotheswarehouse.payload.OutcomeMaterialPostDTO;
import com.sigma.clotheswarehouse.service.OutcomeMaterialService;
import com.sigma.clotheswarehouse.utils.AppConstant;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(AppConstant.BASE_PATH + "/outcomeMaterial")
public class OutcomeMaterialController {

    private final OutcomeMaterialService outcomeMaterialService;

    @PostMapping
    public HttpEntity<?> addOutcomeMaterial(@RequestBody OutcomeMaterialPostDTO outcomeMaterialPostDTO) {
        ApiResponse apiResponse = outcomeMaterialService.addOutcomeMaterial(outcomeMaterialPostDTO);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.CREATED : HttpStatus.CONFLICT).body(apiResponse);
    }
}
