package com.sigma.clotheswarehouse.mapper;

import com.sigma.clotheswarehouse.entity.Material;
import com.sigma.clotheswarehouse.entity.Measurement;
import com.sigma.clotheswarehouse.payload.MaterialGetDTO;
import com.sigma.clotheswarehouse.payload.MaterialPostDTO;
import com.sigma.clotheswarehouse.payload.MeasurementDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MaterialMapperImplCustom implements MaterialMapper {

    @Override
    public Material toEntity(MaterialPostDTO materialDTO) {
        if (materialDTO == null) {
            return null;
        }

        Material material = new Material();

        material.setName(materialDTO.getName());

        return material;
    }

    @Override
    public MaterialGetDTO toGetDTO(Material material) {
        if (material == null) {
            return null;
        }

        MaterialGetDTO materialGetDTO = new MaterialGetDTO();

        materialGetDTO.setMeasurementDTO(measurementToMeasurementDTO(material.getMeasurement()));
        materialGetDTO.setId(material.getId());
        materialGetDTO.setName(material.getName());
        materialGetDTO.setAmount(material.getAmount());
        materialGetDTO.setPrice(material.getPrice() * material.getAmount());

        return materialGetDTO;
    }

    @Override
    public List<MaterialGetDTO> toDTOList(List<Material> materials) {
        if (materials == null) {
            return null;
        }

        List<MaterialGetDTO> list = new ArrayList<>(materials.size());
        for (Material material : materials) {
            list.add(toGetDTO(material));
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
}
