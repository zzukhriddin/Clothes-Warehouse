package com.sigma.clotheswarehouse.mapper;

import com.sigma.clotheswarehouse.entity.OutcomeMaterial;
import com.sigma.clotheswarehouse.payload.OutcomeMaterialGetDTO;
import com.sigma.clotheswarehouse.payload.OutcomeMaterialPostDTO;

import java.util.List;

public interface OutcomeMaterialMapper {

    OutcomeMaterial toEntity(OutcomeMaterialPostDTO outcomeMaterialPostDTO);

    OutcomeMaterialGetDTO toGetDTO(OutcomeMaterial outcomeMaterial);

    List<OutcomeMaterialGetDTO> toGetDTOList(List<OutcomeMaterial> outcomeMaterialList);
}
