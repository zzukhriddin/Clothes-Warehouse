package com.sigma.clotheswarehouse.mapper;

import com.sigma.clotheswarehouse.entity.IncomeMaterial;
import com.sigma.clotheswarehouse.payload.IncomeMaterialDTO;

import java.util.List;


public interface IncomeMaterialMapper {

    IncomeMaterialDTO toGetDTO(IncomeMaterial incomeMaterial);

    IncomeMaterial toEntity(IncomeMaterialDTO incomeMaterialDTO);

    List<IncomeMaterialDTO> toDTOList(List<IncomeMaterial> incomeMaterialList);
}
