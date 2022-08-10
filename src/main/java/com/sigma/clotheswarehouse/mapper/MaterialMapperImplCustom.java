package com.sigma.clotheswarehouse.mapper;

import com.sigma.clotheswarehouse.entity.Material;
import com.sigma.clotheswarehouse.entity.Measurement;
import com.sigma.clotheswarehouse.payload.MaterialGetDTO;
import com.sigma.clotheswarehouse.payload.MaterialPostDTO;
import com.sigma.clotheswarehouse.payload.MaterialUpdateDTO;
import com.sigma.clotheswarehouse.payload.MeasurementDTO;
import com.sigma.clotheswarehouse.repository.MeasurementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class MaterialMapperImplCustom implements MaterialMapper {

    private final MeasurementRepository measurementRepo;

    private final MeasurementMapper measurementMapper;

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
        materialGetDTO.setDeleted(material.isDeleted());

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

    @Override
    public Material toEntityFromUpdateDTO(Material material, MaterialUpdateDTO materialUpdateDTO) {
        if (materialUpdateDTO == null)
            return null;

        material.setName(materialUpdateDTO.getMaterialName());
        material.setAmount(materialUpdateDTO.getAmount());
        material.setPrice(materialUpdateDTO.getPrice());
        material.setDeleted(materialUpdateDTO.isDeleted());

        Optional<Measurement> optionalMeasurement = measurementRepo.findByName(materialUpdateDTO.getMeasurementName());
        if (optionalMeasurement.isEmpty()) {
            MeasurementDTO measurementDTO = new MeasurementDTO();
            measurementDTO.setName(materialUpdateDTO.getMeasurementName());
            material.setMeasurement(measurementRepo.save(measurementMapper.toEntity(measurementDTO)));
        } else
            material.setMeasurement(optionalMeasurement.get());
        return material;
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
