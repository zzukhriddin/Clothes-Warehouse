package com.sigma.clotheswarehouse.controller;

import com.sigma.clotheswarehouse.payload.ApiResponse;
import com.sigma.clotheswarehouse.payload.OutcomeMaterialPostDTO;
import com.sigma.clotheswarehouse.service.OutcomeMaterialService;
import com.sigma.clotheswarehouse.utils.AppConstant;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.sigma.clotheswarehouse.utils.AppConstant.DEFAULT_PAGE;
import static com.sigma.clotheswarehouse.utils.AppConstant.DEFAULT_SIZE;

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

    @GetMapping
    public HttpEntity<?> getAllOutcomeMaterials(
            @RequestParam(value = "page", defaultValue = DEFAULT_PAGE) Integer page,
            @RequestParam(value = "size", defaultValue = DEFAULT_SIZE) Integer size
    ) {
        ApiResponse apiResponse = outcomeMaterialService.getAllOutcomeMaterials(page, size);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }
}
