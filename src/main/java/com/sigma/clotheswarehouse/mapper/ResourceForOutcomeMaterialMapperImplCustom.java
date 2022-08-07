package com.sigma.clotheswarehouse.mapper;

import com.sigma.clotheswarehouse.entity.Material;
import com.sigma.clotheswarehouse.entity.OutcomeMaterial;
import com.sigma.clotheswarehouse.entity.ResourceForOutcomeMaterial;
import com.sigma.clotheswarehouse.payload.ResourceForOutcomeMaterialDTO;
import com.sigma.clotheswarehouse.repository.ResourceForOutcomeMaterialRepository;
import com.sigma.clotheswarehouse.repository.MaterialRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ResourceForOutcomeMaterialMapperImplCustom implements ResourceForOutcomeMaterialMapper {

    private final MaterialRepository materialRepo;

    private final ResourceForOutcomeMaterialRepository resourceForOutcomeMaterialRepo;

    @Override
    public ResourceForOutcomeMaterial toEntity(ResourceForOutcomeMaterialDTO resource) {
        if (resource == null)
            return null;
        ResourceForOutcomeMaterial resourceForOutcomeMaterial = new ResourceForOutcomeMaterial();
        Optional<Material> optionalMaterial = materialRepo.findById(resource.getMaterialId());
        if (optionalMaterial.isPresent()) {
            Material material = optionalMaterial.get();
            material.setAmount(material.getAmount() - resource.getMaterialAmount());
            resourceForOutcomeMaterial.setMaterial(material);
            resourceForOutcomeMaterial.setMaterialAmount(resource.getMaterialAmount());
        } else
            return null;
        return resourceForOutcomeMaterial;
    }

    @Override
    public ResourceForOutcomeMaterial toUpdateEntity(OutcomeMaterial outcomeMaterial, ResourceForOutcomeMaterialDTO resource) {
        if (resource == null)
            return null;
        ResourceForOutcomeMaterial resourceForOutcomeMaterial = new ResourceForOutcomeMaterial();
        Optional<Material> optionalMaterial = materialRepo.findById(resource.getMaterialId());
        if (optionalMaterial.isPresent()) {
            Material material = optionalMaterial.get();
            material.setAmount(material.getAmount() - resource.getMaterialAmount());
            resourceForOutcomeMaterial.setMaterial(material);
            resourceForOutcomeMaterial.setMaterialAmount(resource.getMaterialAmount());
        } else
            return null;
        return resourceForOutcomeMaterial;
    }

    @Override
    public List<ResourceForOutcomeMaterial> toEntityList(List<ResourceForOutcomeMaterialDTO> resources) {
        if (resources == null)
            return null;

        List<ResourceForOutcomeMaterial> resourceForOutcomeMaterials = new LinkedList<>();

        for (ResourceForOutcomeMaterialDTO resource : resources) {
            ResourceForOutcomeMaterial resourceForOutcomeMaterial = toEntity(resource);
            resourceForOutcomeMaterials.add(resourceForOutcomeMaterial);
        }
        return resourceForOutcomeMaterialRepo.saveAll(resourceForOutcomeMaterials);
    }

    @Override
    public List<ResourceForOutcomeMaterial> toUpdateEntityList(OutcomeMaterial outcomeMaterial, List<ResourceForOutcomeMaterialDTO> resources) {
        for (ResourceForOutcomeMaterial outcomeMaterialResource : outcomeMaterial.getResources()) {
            Optional<Material> optionalMaterial = materialRepo.findById(outcomeMaterialResource.getMaterial().getId());
            if (optionalMaterial.isPresent()) {
                Material material = optionalMaterial.get();
                material.setAmount(material.getAmount() + outcomeMaterialResource.getMaterialAmount());
                materialRepo.save(material);
            }
        }
        if (resources == null)
            return null;

        List<ResourceForOutcomeMaterial> resourceForOutcomeMaterials = new LinkedList<>();

        for (ResourceForOutcomeMaterialDTO resource : resources) {
            ResourceForOutcomeMaterial resourceForOutcomeMaterial = toUpdateEntity(outcomeMaterial, resource);
            resourceForOutcomeMaterials.add(resourceForOutcomeMaterial);
        }
        return resourceForOutcomeMaterialRepo.saveAll(resourceForOutcomeMaterials);
    }
}
