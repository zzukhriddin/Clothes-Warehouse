package com.sigma.clotheswarehouse.mapper;

import com.sigma.clotheswarehouse.entity.Measurement;
import com.sigma.clotheswarehouse.payload.MeasurementDTO;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface MeasurementMapper {

    Measurement toEntity(MeasurementDTO measurementDTO);

    MeasurementDTO toDTO(Measurement measurement);

}
