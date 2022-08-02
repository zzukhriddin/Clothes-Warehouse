package com.sigma.clotheswarehouse.controller;

import com.sigma.clotheswarehouse.payload.ApiResponse;
import com.sigma.clotheswarehouse.payload.IncomeMaterialDTO;
import com.sigma.clotheswarehouse.service.IncomeMaterialService;
import com.sigma.clotheswarehouse.utils.AppConstant;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(AppConstant.BASE_PATH + "/incomeMaterial")
public class IncomeMaterialController {

    private final IncomeMaterialService incomeMaterialService;

    @PostMapping
    public HttpEntity<?> addIncomeMaterials(@RequestBody List<IncomeMaterialDTO> incomeMaterialDTOList) {
        ApiResponse apiResponse = incomeMaterialService.addIncomeMaterial(incomeMaterialDTOList);
        return ResponseEntity.ok(apiResponse);
    }

}
