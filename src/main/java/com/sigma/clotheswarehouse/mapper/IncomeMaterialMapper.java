package com.sigma.clotheswarehouse.mapper;

import com.sigma.clotheswarehouse.entity.IncomeMaterial;
import com.sigma.clotheswarehouse.payload.IncomeMaterialDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface IncomeMaterialMapper {

    @Mapping(target = "materialDTO", source = "material")
    @Mapping(target = "measurementDTO", source = "measurement")
    IncomeMaterialDTO toDTO(IncomeMaterial incomeMaterial);

    @Mapping(target = "material", ignore = true)
    @Mapping(target = "measurement", ignore = true)
    IncomeMaterial toEntity(IncomeMaterialDTO incomeMaterialDTO);

}
