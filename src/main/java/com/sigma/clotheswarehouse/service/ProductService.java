package com.sigma.clotheswarehouse.service;

import com.sigma.clotheswarehouse.entity.Measurement;
import com.sigma.clotheswarehouse.entity.Product;
import com.sigma.clotheswarehouse.mapper.ProductMapper;
import com.sigma.clotheswarehouse.payload.ApiResponse;
import com.sigma.clotheswarehouse.payload.ProductDTO;
import com.sigma.clotheswarehouse.payload.ProductGetDto;
import com.sigma.clotheswarehouse.repository.MeasurementRepository;
import com.sigma.clotheswarehouse.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository repository;
    private final MeasurementRepository measurementRepository;

    private final ProductMapper mapper;

    public HttpEntity<?> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page,size);
        Page<Product> productPage = repository.findAll(pageable);
        List<ProductGetDto> DTOs = mapper.getDTOs(productPage.toList());
        return ResponseEntity.ok(DTOs);
    }

    public HttpEntity<?> getById(UUID id) {
        Optional<Product> optionalProduct = repository.findById(id);
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            ProductGetDto productGetDto = mapper.getDTO(product);
            return ResponseEntity.status(200).body(productGetDto);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(false, "PRODUCT_NOT_FOUND"));
    }

    public HttpEntity<?> edit(UUID id, ProductDTO dto) {
        Optional<Product> optionalProduct = repository.findById(id);
        if (optionalProduct.isPresent()) {
            if (dto.getMeasurementId() != null) {
                Optional<Measurement> optionalMeasurement = measurementRepository.findById(dto.getMeasurementId());
                if (optionalMeasurement.isPresent()) {
                    Measurement measurement = optionalMeasurement.get();
                    Product product = optionalProduct.get();
                    product.setName(dto.getName());
                    product.setPrice(dto.getPrice());
                    product.setAmount(dto.getAmount());
                    product.setMeasurement(measurement);
                    product.setDeleted(dto.isDeleted());
                    ProductGetDto productGetDto = mapper.getDTO(repository.save(product));
                    return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse(true,"PRODUCT_EDITED",productGetDto));
                }
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(false, "MEASUREMENT_NOT_FOUND"));
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(false, "PRODUCT_NOT_FOUND"));
    }


    public HttpEntity<?> delete(UUID id) {
        Optional<Product> optionalProduct = repository.findById(id);
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            product.setDeleted(true);
            repository.save(product);
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse(true,"PRODUCT_DELETED"));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(false, "PRODUCT_NOT_FOUND"));
    }
}
