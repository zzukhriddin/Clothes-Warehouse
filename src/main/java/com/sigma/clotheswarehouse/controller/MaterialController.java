package com.sigma.clotheswarehouse.controller;

import com.sigma.clotheswarehouse.payload.ApiResponse;
import com.sigma.clotheswarehouse.service.MaterialService;
import com.sigma.clotheswarehouse.utils.AppConstant;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import static com.sigma.clotheswarehouse.utils.AppConstant.DEFAULT_PAGE;
import static com.sigma.clotheswarehouse.utils.AppConstant.DEFAULT_SIZE;

@RestController
@RequiredArgsConstructor
@RequestMapping(AppConstant.BASE_PATH + "/material")
public class MaterialController {

    private final MaterialService materialService;
    private static final String ALL_MATERIALS = "/all";

    private static final String MATERIAL_BY_ID = "/byId";


    @GetMapping(ALL_MATERIALS)
    public HttpEntity<?> getAllMaterials(
            @RequestParam(value = "page", defaultValue = DEFAULT_PAGE) Integer page,
            @RequestParam(value = "size", defaultValue = DEFAULT_SIZE) Integer size
    ) {
        ApiResponse apiResponse = materialService.getAllMaterials(page, size);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 400).body(apiResponse);
    }

    @GetMapping(MATERIAL_BY_ID)
    public HttpEntity<?> getMaterialById(@RequestParam(name = "materialId") UUID materialId) {
        ApiResponse apiResponse = materialService.getMaterialById(materialId);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 404).body(apiResponse);
    }
}
