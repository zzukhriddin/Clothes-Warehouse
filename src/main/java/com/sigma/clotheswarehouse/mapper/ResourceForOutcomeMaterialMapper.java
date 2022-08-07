package com.sigma.clotheswarehouse.mapper;

import com.sigma.clotheswarehouse.entity.OutcomeMaterial;
import com.sigma.clotheswarehouse.entity.ResourceForOutcomeMaterial;
import com.sigma.clotheswarehouse.payload.ResourceForOutcomeMaterialDTO;

import java.util.List;

public interface ResourceForOutcomeMaterialMapper {

    ResourceForOutcomeMaterial toEntity(ResourceForOutcomeMaterialDTO resource);

    ResourceForOutcomeMaterial toUpdateEntity(OutcomeMaterial outcomeMaterial, ResourceForOutcomeMaterialDTO resource);

    List<ResourceForOutcomeMaterial> toEntityList(List<ResourceForOutcomeMaterialDTO> resources);

    List<ResourceForOutcomeMaterial> toUpdateEntityList(OutcomeMaterial outcomeMaterial, List<ResourceForOutcomeMaterialDTO> resources);


}
