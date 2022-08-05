package com.sigma.clotheswarehouse.mapper;

import com.sigma.clotheswarehouse.entity.Product;
import com.sigma.clotheswarehouse.payload.ProductDTO;
import com.sigma.clotheswarehouse.payload.ProductGetDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {


    @Mapping(target = "measurement.id", source = "measurementId")
    Product toEntity(ProductDTO dto);


    @Mapping(target = "measurementId", source = "measurement.id")
    ProductDTO toDTO(Product product);


    @Mapping(target = "measurementDTO", source = "measurement")
    ProductGetDto getDTO(Product product);


    List<ProductGetDto> getDTOs(List<Product> productList);
}
