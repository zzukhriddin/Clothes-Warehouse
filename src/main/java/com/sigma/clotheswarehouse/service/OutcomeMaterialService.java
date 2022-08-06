package com.sigma.clotheswarehouse.service;

import com.sigma.clotheswarehouse.entity.OutcomeMaterial;
import com.sigma.clotheswarehouse.entity.ResourceForOutcomeMaterial;
import com.sigma.clotheswarehouse.mapper.OutcomeMaterialMapper;
import com.sigma.clotheswarehouse.mapper.ResourceForOutcomeMaterialMapper;
import com.sigma.clotheswarehouse.payload.ApiResponse;
import com.sigma.clotheswarehouse.payload.OutcomeMaterialPostDTO;
import com.sigma.clotheswarehouse.repository.OutcomeMaterialRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
