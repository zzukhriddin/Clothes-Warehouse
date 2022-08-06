package com.sigma.clotheswarehouse.mapper;

import com.sigma.clotheswarehouse.entity.OutcomeMaterial;
import com.sigma.clotheswarehouse.entity.Product;
import com.sigma.clotheswarehouse.payload.OutcomeMaterialPostDTO;
import com.sigma.clotheswarehouse.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

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

        outcomeMaterial.setAmount(outcomeMaterialPostDTO.getProductAmount());

        Optional<Product> optionalProduct = productRepo.findById(outcomeMaterialPostDTO.getProductId());
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            product.setPrice(outcomeMaterialPostDTO.getProductPrice());
            product.setAmount(outcomeMaterialPostDTO.getProductAmount() + product.getAmount());
            outcomeMaterial.setProduct(product);
            return outcomeMaterial;
        }
        return null;
    }
}
