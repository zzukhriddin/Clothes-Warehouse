package com.sigma.clotheswarehouse.mapper;

import com.sigma.clotheswarehouse.entity.Material;
import com.sigma.clotheswarehouse.payload.MaterialGetDTO;
import com.sigma.clotheswarehouse.payload.MaterialPostDTO;
import com.sigma.clotheswarehouse.payload.MaterialUpdateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

public interface MaterialMapper {

    Material toEntity(MaterialPostDTO materialDTO);

    MaterialGetDTO toGetDTO(Material material);

    List<MaterialGetDTO> toDTOList(List<Material> materials);

    Material toEntityFromUpdateDTO(Material material, MaterialUpdateDTO materialUpdateDTO);

}
