package com.sigma.clotheswarehouse.mapper;

import com.sigma.clotheswarehouse.entity.Material;
import com.sigma.clotheswarehouse.payload.MaterialGetDTO;
import com.sigma.clotheswarehouse.payload.MaterialPostDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface MaterialMapper {

    @Mapping(target = "measurement", ignore = true)
    Material toEntity(MaterialPostDTO materialDTO);

    @Mapping(target = "measurementDTO", source = "measurement")
    MaterialGetDTO toGetDTO(Material material);

    @Mapping(target = "measurementDTO", source = "measurement")
    List<MaterialGetDTO> toDTOList(List<Material> materials);

}
