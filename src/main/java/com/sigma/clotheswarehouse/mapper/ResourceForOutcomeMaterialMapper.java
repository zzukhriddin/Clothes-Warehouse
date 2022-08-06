package com.sigma.clotheswarehouse.mapper;

import com.sigma.clotheswarehouse.entity.ResourceForOutcomeMaterial;
import com.sigma.clotheswarehouse.payload.ResourceForOutcomeMaterialDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface ResourceForOutcomeMaterialMapper {

    ResourceForOutcomeMaterial toEntity(ResourceForOutcomeMaterialDTO resource);

    List<ResourceForOutcomeMaterial> toEntityList(List<ResourceForOutcomeMaterialDTO> resources);
}
