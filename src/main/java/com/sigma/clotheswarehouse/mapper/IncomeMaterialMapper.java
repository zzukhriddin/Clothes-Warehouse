package com.sigma.clotheswarehouse.mapper;

import com.sigma.clotheswarehouse.entity.IncomeMaterial;
import com.sigma.clotheswarehouse.payload.IncomeMaterialDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class IncomeMaterialMapper {

    private final MaterialMapper materialMapper;

    private final MeasurementMapper measurementMapper;


    public IncomeMaterial incomeMaterialDTOToIncomeMaterial(IncomeMaterialDTO incomeMaterialDTO) {
        IncomeMaterial incomeMaterial = new IncomeMaterial();
        incomeMaterial.setMaterial(materialMapper.materialDTOToMaterial(incomeMaterialDTO));
        incomeMaterial.setIncomeDate(incomeMaterialDTO.getIncomeDate());
        incomeMaterial.setAmount(incomeMaterialDTO.getAmount());
        incomeMaterial.setPrice(incomeMaterialDTO.getPrice());
        incomeMaterial.setMeasurement(measurementMapper.measurementDTOToMeasurement(incomeMaterialDTO.getMeasurementDTO()));
        return incomeMaterial;
    }

}
