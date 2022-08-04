package com.sigma.clotheswarehouse.mapper;

import com.sigma.clotheswarehouse.entity.Measurement;
import com.sigma.clotheswarehouse.payload.MeasurementDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface MeasurementMapper {

    @Mapping(target = "id", ignore = true)
    Measurement toEntity(MeasurementDTO measurementDTO);

}
