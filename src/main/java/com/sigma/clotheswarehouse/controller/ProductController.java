package com.sigma.clotheswarehouse.controller;

import com.sigma.clotheswarehouse.payload.ProductDTO;
import com.sigma.clotheswarehouse.service.ProductService;
import com.sigma.clotheswarehouse.utils.AppConstant;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(AppConstant.BASE_PATH + "/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public HttpEntity<?> getAll() {
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getById(@PathVariable UUID id) {
        return productService.getById(id);
    }



    @PutMapping("/{id}")
    public HttpEntity<?> edit(@PathVariable UUID id, @RequestBody ProductDTO dto) {
        return productService.edit(id,dto);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable UUID id){
        return productService.delete(id);
    }
}

