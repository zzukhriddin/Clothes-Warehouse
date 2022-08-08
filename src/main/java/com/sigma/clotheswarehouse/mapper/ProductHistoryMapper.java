package com.sigma.clotheswarehouse.mapper;

import com.sigma.clotheswarehouse.entity.ProductHistory;
import com.sigma.clotheswarehouse.payload.ProductHistoryDTO;
import com.sigma.clotheswarehouse.payload.ProductHistoryGetDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductHistoryMapper {

    @Mapping(target = "client", source = "clientId")
    @Mapping(target = "product", source = "productId")
    ProductHistory toEntity(ProductHistoryDTO productHistoryDTO);


    @Mapping(target = "productId", source = "product")
    @Mapping(target = "clientId", source = "client")
    ProductHistoryDTO toDTO(ProductHistory productHistory);


    @Mapping(target = "clientGetDto", source = "client")
    @Mapping(target = "productGetDto", source = "product")
    ProductHistoryGetDTO toGetDTO(ProductHistory productHistory);

    List<ProductHistoryGetDTO> toGetDTOList(List<ProductHistory> productHistoryList);
}
