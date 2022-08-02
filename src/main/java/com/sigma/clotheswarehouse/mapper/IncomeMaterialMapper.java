package com.sigma.clotheswarehouse.mapper;

import com.sigma.clotheswarehouse.entity.IncomeMaterial;
import com.sigma.clotheswarehouse.payload.IncomeMaterialGetDTO;
import com.sigma.clotheswarehouse.payload.IncomeMaterialPostDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;


@Mapper(componentModel = "spring")
public interface IncomeMaterialMapper {

    @Mapping(target = "materialPostDTO", source = "material")
    @Mapping(target = "measurementDTO", source = "measurement")
    IncomeMaterialPostDTO toPostDTO(IncomeMaterial incomeMaterial);

    @Mapping(target = "materialGetDTO", source = "material")
    @Mapping(target = "measurementDTO", source = "measurement")
    IncomeMaterialGetDTO toGetDTO(IncomeMaterial incomeMaterial);

    @Mapping(target = "material", ignore = true)
    @Mapping(target = "measurement", ignore = true)
    IncomeMaterial toEntity(IncomeMaterialPostDTO incomeMaterialDTO);

    @Mapping(target = "materialPostDTO", source = "material")
    @Mapping(target = "measurementDTO", source = "measurement")
    List<IncomeMaterialGetDTO> toDTOList(List<IncomeMaterial> incomeMaterialList);
}
