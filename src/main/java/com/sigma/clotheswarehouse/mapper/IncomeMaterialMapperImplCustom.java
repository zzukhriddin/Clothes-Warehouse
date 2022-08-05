package com.sigma.clotheswarehouse.mapper;

import com.sigma.clotheswarehouse.entity.IncomeMaterial;
import com.sigma.clotheswarehouse.entity.Material;
import com.sigma.clotheswarehouse.entity.Measurement;
import com.sigma.clotheswarehouse.payload.IncomeMaterialDTO;
import com.sigma.clotheswarehouse.payload.MaterialPostDTO;
import com.sigma.clotheswarehouse.payload.MeasurementDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class IncomeMaterialMapperImplCustom implements IncomeMaterialMapper {

    @Override
    public IncomeMaterialDTO toGetDTO(IncomeMaterial incomeMaterial) {
        if (incomeMaterial == null) {
            return null;
        }

        IncomeMaterialDTO incomeMaterialGetDTO = new IncomeMaterialDTO();

        incomeMaterialGetDTO.setMaterialPostDTO(materialToMaterialPostDTO(incomeMaterial.getMaterial()));
        incomeMaterialGetDTO.setIncomeDate(incomeMaterial.getIncomeDate());
        incomeMaterialGetDTO.setAmount(incomeMaterial.getAmount());
        incomeMaterialGetDTO.setPrice(incomeMaterial.getPrice() * incomeMaterial.getAmount());

        return incomeMaterialGetDTO;
    }

    @Override
    public IncomeMaterial toEntity(IncomeMaterialDTO incomeMaterialDTO) {
        if (incomeMaterialDTO == null) {
            return null;
        }

        IncomeMaterial incomeMaterial = new IncomeMaterial();

        incomeMaterial.setIncomeDate(incomeMaterialDTO.getIncomeDate());
        incomeMaterial.setAmount(incomeMaterialDTO.getAmount());
        incomeMaterial.setPrice(incomeMaterialDTO.getPrice());

        return incomeMaterial;
    }

    @Override
    public List<IncomeMaterialDTO> toDTOList(List<IncomeMaterial> incomeMaterialList) {
        if (incomeMaterialList == null) {
            return null;
        }

        List<IncomeMaterialDTO> list = new ArrayList<>(incomeMaterialList.size());
        for (IncomeMaterial incomeMaterial : incomeMaterialList) {
            list.add(toGetDTO(incomeMaterial));
        }

        return list;
    }

    protected MeasurementDTO measurementToMeasurementDTO(Measurement measurement) {
        if (measurement == null) {
            return null;
        }

        MeasurementDTO measurementDTO = new MeasurementDTO();

        measurementDTO.setName(measurement.getName());

        return measurementDTO;
    }

    protected MaterialPostDTO materialToMaterialPostDTO(Material material) {
        if (material == null) {
            return null;
        }

        MaterialPostDTO materialPostDTO = new MaterialPostDTO();

        materialPostDTO.setMeasurementDTO(measurementToMeasurementDTO(material.getMeasurement()));
        materialPostDTO.setName(material.getName());

        return materialPostDTO;
    }
}
