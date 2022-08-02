package com.sigma.clotheswarehouse.mapper;

import com.sigma.clotheswarehouse.entity.Material;
import com.sigma.clotheswarehouse.payload.IncomeMaterialDTO;
import com.sigma.clotheswarehouse.repository.MaterialRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class MaterialMapper {

    private final MaterialRepository materialRepository;

    public Material materialDTOToMaterial(IncomeMaterialDTO incomeMaterialDTO) {
        Material material = new Material();
        Optional<Material> optionalMaterial = materialRepository.findByName(incomeMaterialDTO.getMaterialDTO().getName());
        if (optionalMaterial.isPresent()) {
            material = optionalMaterial.get();
        }
        material.setName(incomeMaterialDTO.getMaterialDTO().getName());
        material.setAmount(material.getAmount() + incomeMaterialDTO.getAmount());
        material.setPrice(material.getPrice() + incomeMaterialDTO.getPrice() * incomeMaterialDTO.getAmount());

        // Saving material
        return materialRepository.save(material);
    }
}
