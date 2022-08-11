package com.sigma.clotheswarehouse.mapper;

import com.sigma.clotheswarehouse.entity.*;
import com.sigma.clotheswarehouse.payload.OutcomeMaterialGetDTO;
import com.sigma.clotheswarehouse.payload.OutcomeMaterialPostDTO;
import com.sigma.clotheswarehouse.payload.ResourceForOutcomeMaterialGetDTO;
import com.sigma.clotheswarehouse.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class OutcomeMaterialMapperImplCustom implements OutcomeMaterialMapper {

    private final ProductRepository productRepo;

    @Override
    public OutcomeMaterial toEntity(OutcomeMaterialPostDTO outcomeMaterialPostDTO) {
        if (outcomeMaterialPostDTO == null) {
            return null;
        }

        OutcomeMaterial outcomeMaterial = new OutcomeMaterial();

        outcomeMaterial.setProductAmount(outcomeMaterialPostDTO.getProductAmount());

        outcomeMaterial.setProductNewPrice(outcomeMaterialPostDTO.getProductPrice());

        Optional<Product> optionalProduct = productRepo.findByIdAndDeletedFalse(outcomeMaterialPostDTO.getProductId());
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            outcomeMaterial.setProductOldPrice(product.getPrice());
            product.setPrice(outcomeMaterialPostDTO.getProductPrice());
            product.setAmount(outcomeMaterialPostDTO.getProductAmount() + product.getAmount());
            outcomeMaterial.setProduct(product);
            return outcomeMaterial;
        }
        return null;
    }

    @Override
    public OutcomeMaterialGetDTO toGetDTO(OutcomeMaterial outcomeMaterial) {
        if (outcomeMaterial == null) {
            return null;
        }

        OutcomeMaterialGetDTO outcomeMaterialGetDTO = new OutcomeMaterialGetDTO();

        outcomeMaterialGetDTO.setId(outcomeMaterial.getId());
        outcomeMaterialGetDTO.setProductName(outcomeMaterialProductName(outcomeMaterial));
        outcomeMaterialGetDTO.setProductMeasurementName(outcomeMaterialProductMeasurementName(outcomeMaterial));
        outcomeMaterialGetDTO.setProductCategoryName(outcomeMaterialProductCategoryName(outcomeMaterial));
        outcomeMaterialGetDTO.setProductAmount(outcomeMaterial.getProductAmount());
        outcomeMaterialGetDTO.setTotalProductPrice(outcomeMaterial.getProductAmount() * outcomeMaterial.getProductNewPrice());
        outcomeMaterialGetDTO.setMaterials(resourceForOutcomeMaterialListToResourceForOutcomeMaterialGetDTOList(outcomeMaterial.getResources()));

        return outcomeMaterialGetDTO;
    }

    @Override
    public List<OutcomeMaterialGetDTO> toGetDTOList(List<OutcomeMaterial> outcomeMaterialList) {
        if (outcomeMaterialList == null) {
            return null;
        }

        List<OutcomeMaterialGetDTO> list = new ArrayList<>(outcomeMaterialList.size());
        for (OutcomeMaterial outcomeMaterial : outcomeMaterialList) {
            list.add(toGetDTO(outcomeMaterial));
        }

        return list;
    }

    private String outcomeMaterialProductName(OutcomeMaterial outcomeMaterial) {
        if (outcomeMaterial == null) {
            return null;
        }
        Product product = outcomeMaterial.getProduct();
        if (product == null) {
            return null;
        }
        return product.getName();
    }

    private String outcomeMaterialProductMeasurementName(OutcomeMaterial outcomeMaterial) {
        if (outcomeMaterial == null) {
            return null;
        }
        Product product = outcomeMaterial.getProduct();
        if (product == null) {
            return null;
        }
        Measurement measurement = product.getMeasurement();
        if (measurement == null) {
            return null;
        }
        return measurement.getName();
    }

    private String outcomeMaterialProductCategoryName(OutcomeMaterial outcomeMaterial) {
        if (outcomeMaterial == null) {
            return null;
        }
        Product product = outcomeMaterial.getProduct();
        if (product == null) {
            return null;
        }
        Category category = product.getCategory();
        if (category == null) {
            return null;
        }
        return category.getName();
    }

    protected ResourceForOutcomeMaterialGetDTO resourceForOutcomeMaterialToResourceForOutcomeMaterialGetDTO(ResourceForOutcomeMaterial resourceForOutcomeMaterial) {
        if (resourceForOutcomeMaterial == null) {
            return null;
        }

        ResourceForOutcomeMaterialGetDTO resourceForOutcomeMaterialGetDTO = new ResourceForOutcomeMaterialGetDTO();

        resourceForOutcomeMaterialGetDTO.setMaterialName(resourceForOutcomeMaterial.getMaterial().getName());

        resourceForOutcomeMaterialGetDTO.setMeasurementName(resourceForOutcomeMaterial.getMaterial().getMeasurement().getName());

        resourceForOutcomeMaterialGetDTO.setMaterialAmount(resourceForOutcomeMaterial.getMaterialAmount());

        return resourceForOutcomeMaterialGetDTO;
    }

    protected List<ResourceForOutcomeMaterialGetDTO> resourceForOutcomeMaterialListToResourceForOutcomeMaterialGetDTOList(List<ResourceForOutcomeMaterial> list) {
        if (list == null) {
            return null;
        }

        List<ResourceForOutcomeMaterialGetDTO> list1 = new ArrayList<>(list.size());
        for (ResourceForOutcomeMaterial resourceForOutcomeMaterial : list) {
            list1.add(resourceForOutcomeMaterialToResourceForOutcomeMaterialGetDTO(resourceForOutcomeMaterial));
        }

        return list1;
    }
}
