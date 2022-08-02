package com.sigma.clotheswarehouse.mapper;

import com.sigma.clotheswarehouse.entity.Material;
import com.sigma.clotheswarehouse.payload.MaterialGetDTO;
import com.sigma.clotheswarehouse.payload.MaterialPostDTO;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring")
public interface MaterialMapper {

    Material toEntity(MaterialPostDTO materialDTO);

    MaterialPostDTO toPostDTO(Material material);

    MaterialGetDTO toGetDTO(Material material);

    List<MaterialGetDTO> toDTOList(List<Material> materials);

}
