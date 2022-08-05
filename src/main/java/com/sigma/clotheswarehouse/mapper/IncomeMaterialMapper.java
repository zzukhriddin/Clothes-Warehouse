package com.sigma.clotheswarehouse.mapper;

import com.sigma.clotheswarehouse.entity.IncomeMaterial;
import com.sigma.clotheswarehouse.payload.IncomeMaterialDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;


@Mapper
public interface IncomeMaterialMapper {


    @Mapping(target = "materialPostDTO", source = "material")
    @Mapping(target = "materialPostDTO.measurementDTO", source = "material.measurement")
    IncomeMaterialDTO toGetDTO(IncomeMaterial incomeMaterial);

    @Mapping(target = "material", ignore = true)
    IncomeMaterial toEntity(IncomeMaterialDTO incomeMaterialDTO);

    @Mapping(target = "materialPostDTO", source = "material")
    List<IncomeMaterialDTO> toDTOList(List<IncomeMaterial> incomeMaterialList);
}
