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


    public IncomeMaterial generateIncomeMaterialFromIncomeMaterialDTO(IncomeMaterialDTO incomeMaterialDTO) {
        IncomeMaterial incomeMaterial = new IncomeMaterial();
        incomeMaterial.setMaterial(materialMapper.generateMaterialFromMaterialDTO(incomeMaterialDTO));
        incomeMaterial.setIncomeDate(incomeMaterialDTO.getIncomeDate());
        incomeMaterial.setAmount(incomeMaterialDTO.getAmount());
        incomeMaterial.setPrice(incomeMaterialDTO.getPrice());
        incomeMaterial.setMeasurement(measurementMapper.generateMeasurementFromMeasurementDTO(incomeMaterialDTO.getMeasurementDTO()));
        return incomeMaterial;
    }

    public IncomeMaterialDTO generateIncomeMaterialDTOFromIncomeMaterial(IncomeMaterial incomeMaterial) {
        IncomeMaterialDTO incomeMaterialDTO = new IncomeMaterialDTO();
        incomeMaterialDTO.setMaterialDTO(materialMapper.generateMaterialDTOFromMaterial(incomeMaterial.getMaterial()));
        incomeMaterialDTO.setIncomeDate(incomeMaterial.getIncomeDate());
        incomeMaterialDTO.setAmount(incomeMaterial.getAmount());
        incomeMaterialDTO.setPrice(incomeMaterial.getPrice());
        incomeMaterialDTO.setMeasurementDTO(measurementMapper.generateMeasurementDTOFromMeasurement(incomeMaterial.getMeasurement()));
        return incomeMaterialDTO;
    }

}
