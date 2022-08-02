package com.sigma.clotheswarehouse.service;

import com.sigma.clotheswarehouse.entity.IncomeMaterial;
import com.sigma.clotheswarehouse.entity.Material;
import com.sigma.clotheswarehouse.entity.Measurement;
import com.sigma.clotheswarehouse.exceptions.PageSizeException;
import com.sigma.clotheswarehouse.mapper.IncomeMaterialMapper;
import com.sigma.clotheswarehouse.mapper.MaterialMapper;
import com.sigma.clotheswarehouse.mapper.MeasurementMapper;
import com.sigma.clotheswarehouse.payload.ApiResponse;
import com.sigma.clotheswarehouse.payload.IncomeMaterialDTO;
import com.sigma.clotheswarehouse.repository.IncomeMaterialRepository;
import com.sigma.clotheswarehouse.repository.MaterialRepository;
import com.sigma.clotheswarehouse.repository.MeasurementRepository;
import com.sigma.clotheswarehouse.utils.CommandUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class IncomeMaterialService {

    private final MaterialMapper materialMapper;

    private final MeasurementMapper measurementMapper;

    private final MaterialRepository materialRepository;

    private final MeasurementRepository measurementRepository;

    private final IncomeMaterialRepository incomeMaterialRepo;

    private final IncomeMaterialMapper incomeMaterialMapper;


    public ApiResponse addIncomeMaterial(List<IncomeMaterialDTO> incomeMaterialDTOList) {
        List<IncomeMaterial> incomeMaterialList = new LinkedList<>();
        for (IncomeMaterialDTO incomeMaterialDTO : incomeMaterialDTOList) {
            IncomeMaterial incomeMaterial = incomeMaterialMapper.toEntity(incomeMaterialDTO);

            Material material = materialMapper.toEntity(incomeMaterialDTO.getMaterialDTO());
            Optional<Material> optionalMaterial = materialRepository.findByName(material.getName());
            if (optionalMaterial.isPresent()) {
                Material material1 = optionalMaterial.get();
                material1.setAmount(material1.getAmount() + incomeMaterialDTO.getAmount());
                material1.setPrice(material1.getPrice() + incomeMaterialDTO.getAmount() * incomeMaterialDTO.getPrice());
                incomeMaterial.setMaterial(material1);
            } else {
                material.setAmount(incomeMaterialDTO.getAmount());
                material.setPrice(incomeMaterialDTO.getPrice()* incomeMaterialDTO.getAmount());
                incomeMaterial.setMaterial(materialRepository.save(material));
            }

            Measurement measurement = measurementMapper.toEntity(incomeMaterialDTO.getMeasurementDTO());
            Optional<Measurement> optionalMeasurement = measurementRepository.findByName(measurement.getName());
            if (optionalMeasurement.isPresent())
                incomeMaterial.setMeasurement(optionalMeasurement.get());
            else
                incomeMaterial.setMeasurement(measurementRepository.save(measurement));

            incomeMaterialList.add(incomeMaterial);
        }
        incomeMaterialRepo.saveAll(incomeMaterialList);
        return new ApiResponse(true, "Successfully saved");
    }

    public ApiResponse getAllIncomeMaterials(Integer page, Integer size) {
        List<IncomeMaterialDTO> incomeMaterialDTOList = new ArrayList<>();
        Page<IncomeMaterial> incomeMaterialPage;
        try {
            incomeMaterialPage = incomeMaterialRepo.findAll(CommandUtils.simplePageable(page, size));
        } catch (PageSizeException e) {
            return new ApiResponse(false, e.getMessage());
        }
        for (IncomeMaterial incomeMaterial : incomeMaterialPage) {
            IncomeMaterialDTO incomeMaterialDTO = incomeMaterialMapper.toDTO(incomeMaterial);
            incomeMaterialDTOList.add(incomeMaterialDTO);
        }
        return new ApiResponse(true, "Income materials with Page", incomeMaterialDTOList);
    }
}
