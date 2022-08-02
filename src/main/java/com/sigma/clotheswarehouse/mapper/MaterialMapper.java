package com.sigma.clotheswarehouse.mapper;

import com.sigma.clotheswarehouse.entity.Material;
import com.sigma.clotheswarehouse.payload.MaterialDTO;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface MaterialMapper {

    Material toEntity(MaterialDTO materialDTO);

    MaterialDTO toDTO(Material material);

}
