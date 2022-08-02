package com.sigma.clotheswarehouse.service;

import com.sigma.clotheswarehouse.entity.Material;
import com.sigma.clotheswarehouse.exceptions.PageSizeException;
import com.sigma.clotheswarehouse.mapper.MaterialMapper;
import com.sigma.clotheswarehouse.payload.ApiResponse;
import com.sigma.clotheswarehouse.payload.MaterialGetDTO;
import com.sigma.clotheswarehouse.repository.MaterialRepository;
import com.sigma.clotheswarehouse.utils.CommandUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
@RequiredArgsConstructor
public class MaterialService {

    private final MaterialRepository materialRepo;

    private final MaterialMapper materialMapper;


    public ApiResponse getAllMaterials(Integer page, Integer size) {
        Page<Material> materialPage;
        try {
            materialPage = materialRepo.findAll(CommandUtils.simplePageable(page, size));
        } catch (PageSizeException e) {
            return new ApiResponse(false, e.getMessage());
        }
        List<MaterialGetDTO> materialGetDTOS = materialMapper.toDTOList(materialPage.getContent());
        Map<String, Object> response = new HashMap<>();
        response.put("materials", materialGetDTOS);
        response.put("currentPage", materialPage.getNumber());
        response.put("totalItems", materialPage.getTotalElements());
        response.put("totalPages", materialPage.getTotalPages());
        return new ApiResponse(true, "All materials with page", response);
    }

    public ApiResponse getMaterialById(UUID materialId) {
        Optional<Material> optionalMaterial = materialRepo.findById(materialId);
        if (optionalMaterial.isEmpty())
            return new ApiResponse(false, "Such a material does not exist");
        MaterialGetDTO materialGetDTO = materialMapper.toGetDTO(optionalMaterial.get());
        return new ApiResponse(true, "Success", materialGetDTO);
    }
}
