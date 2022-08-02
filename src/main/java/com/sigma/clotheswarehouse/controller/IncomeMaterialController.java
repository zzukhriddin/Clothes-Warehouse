package com.sigma.clotheswarehouse.controller;

import com.sigma.clotheswarehouse.payload.ApiResponse;
import com.sigma.clotheswarehouse.payload.IncomeMaterialPostDTO;
import com.sigma.clotheswarehouse.service.IncomeMaterialService;
import com.sigma.clotheswarehouse.utils.AppConstant;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.sigma.clotheswarehouse.utils.AppConstant.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(AppConstant.BASE_PATH + "/incomeMaterial")
public class IncomeMaterialController {

    private final IncomeMaterialService incomeMaterialService;

    private static final String ALL_INCOME_MATERIALS = "/all";

    @PostMapping
    public HttpEntity<?> addIncomeMaterials(@RequestBody List<IncomeMaterialPostDTO> incomeMaterialDTOList) {
        ApiResponse apiResponse = incomeMaterialService.addIncomeMaterial(incomeMaterialDTOList);
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping(ALL_INCOME_MATERIALS)
    public HttpEntity<?> getAllIncomeMaterials(
            @RequestParam(value = "page", defaultValue = DEFAULT_PAGE) Integer page,
            @RequestParam(value = "size", defaultValue = DEFAULT_SIZE) Integer size
    ) {
        ApiResponse apiResponse = incomeMaterialService.getAllIncomeMaterials(page, size);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 400).body(apiResponse);
    }


}
