package com.sigma.clotheswarehouse.service;

import com.sigma.clotheswarehouse.entity.OutcomeMaterial;
import com.sigma.clotheswarehouse.entity.ResourceForOutcomeMaterial;
import com.sigma.clotheswarehouse.exceptions.PageSizeException;
import com.sigma.clotheswarehouse.mapper.OutcomeMaterialMapper;
import com.sigma.clotheswarehouse.mapper.ResourceForOutcomeMaterialMapper;
import com.sigma.clotheswarehouse.payload.ApiResponse;
import com.sigma.clotheswarehouse.payload.OutcomeMaterialGetDTO;
import com.sigma.clotheswarehouse.payload.OutcomeMaterialPostDTO;
import com.sigma.clotheswarehouse.repository.OutcomeMaterialRepository;
import com.sigma.clotheswarehouse.utils.CommandUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class OutcomeMaterialService {

    private final OutcomeMaterialRepository outcomeMaterialRepo;

    private final OutcomeMaterialMapper outcomeMaterialMapper;

    private final ResourceForOutcomeMaterialMapper resourceMapper;

    public ApiResponse addOutcomeMaterial(OutcomeMaterialPostDTO outcomeMaterialPostDTO) {
        OutcomeMaterial outcomeMaterial = outcomeMaterialMapper.toEntity(outcomeMaterialPostDTO);
        if (outcomeMaterial == null) {
            return new ApiResponse(false, "Such a product does not exist or outcome material is NULL");
        }
        List<ResourceForOutcomeMaterial> resourceForOutcomeMaterials = resourceMapper.toEntityList(outcomeMaterialPostDTO.getResources());
        if (resourceForOutcomeMaterials == null)
            return new ApiResponse(false, "Such materials do not exist");
        outcomeMaterial.setResources(resourceForOutcomeMaterials);
        outcomeMaterialRepo.save(outcomeMaterial);
        return new ApiResponse(true, "Successfully saved");
    }

    public ApiResponse getAllOutcomeMaterials(Integer page, Integer size) {
        Page<OutcomeMaterial> outcomeMaterialPage;
        try {
            outcomeMaterialPage = outcomeMaterialRepo.findAll(CommandUtils.simplePageable(page, size));
        } catch (PageSizeException e) {
            return new ApiResponse(false, e.getMessage());
        }
        List<OutcomeMaterialGetDTO> outcomeMaterialGetDTOList = outcomeMaterialMapper.toGetDTOList(outcomeMaterialPage.getContent());
        Map<String, Object> response = new HashMap<>();
        response.put("materials", outcomeMaterialGetDTOList);
        response.put("currentPage", outcomeMaterialPage.getNumber());
        response.put("totalItems", outcomeMaterialPage.getTotalElements());
        response.put("totalPages", outcomeMaterialPage.getTotalPages());
        return new ApiResponse(true, "All outcome materials", response);
    }
}
