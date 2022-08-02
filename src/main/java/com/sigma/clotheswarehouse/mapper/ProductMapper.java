package com.sigma.clotheswarehouse.mapper;

import com.sigma.clotheswarehouse.entity.Product;
import com.sigma.clotheswarehouse.payload.ProductDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(target = "measurement.id", source = "measurementId")
    Product toEntity(ProductDTO dto);


    @Mapping(target = "measurementId", source = "measurement.id")
    ProductDTO toDTO(Product product);
}
