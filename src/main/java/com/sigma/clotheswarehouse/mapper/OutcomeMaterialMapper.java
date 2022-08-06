package com.sigma.clotheswarehouse.mapper;

import com.sigma.clotheswarehouse.entity.OutcomeMaterial;
import com.sigma.clotheswarehouse.payload.OutcomeMaterialGetDTO;
import com.sigma.clotheswarehouse.payload.OutcomeMaterialPostDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface OutcomeMaterialMapper {



//    @Mapping(target = "resources", ignore = true)
//    @Mapping(target = "product", ignore = true)
    OutcomeMaterial toEntity(OutcomeMaterialPostDTO outcomeMaterialPostDTO);

//    @Mapping(target = "productName", source = "product.name")
//    @Mapping(target = "productMeasurementName", source = "product.measurement.name")
//    @Mapping(target = "productCategoryName", source = "product.category.name")
//    @Mapping(target = "totalProductPrice", ignore = true)
//    @Mapping(target = "materials", source = "resources")
    OutcomeMaterialGetDTO toGetDTO(OutcomeMaterial outcomeMaterial);

    List<OutcomeMaterialGetDTO> toGetDTOList(List<OutcomeMaterial> outcomeMaterialList);
}
