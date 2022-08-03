package com.sigma.clotheswarehouse.mapper;

import com.sigma.clotheswarehouse.entity.IncomeMaterial;
import com.sigma.clotheswarehouse.entity.Material;
import com.sigma.clotheswarehouse.entity.Measurement;
import com.sigma.clotheswarehouse.payload.*;
import org.springframework.stereotype.Component;

import javax.annotation.processing.Generated;
import java.util.ArrayList;
import java.util.List;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-03T12:46:32+0500",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 18.0.1.1 (Oracle Corporation)"
)
@Component
public class IncomeMaterialMapperImpl implements IncomeMaterialMapper {

    @Override
    public IncomeMaterialPostDTO toPostDTO(IncomeMaterial incomeMaterial) {
        if ( incomeMaterial == null ) {
            return null;
        }

        IncomeMaterialPostDTO incomeMaterialPostDTO = new IncomeMaterialPostDTO();

        incomeMaterialPostDTO.setMaterialPostDTO( materialToMaterialPostDTO( incomeMaterial.getMaterial() ) );
        incomeMaterialPostDTO.setMeasurementDTO( measurementToMeasurementDTO( incomeMaterial.getMeasurement() ) );
        incomeMaterialPostDTO.setIncomeDate( incomeMaterial.getIncomeDate() );
        incomeMaterialPostDTO.setAmount( incomeMaterial.getAmount() );
        incomeMaterialPostDTO.setPrice( incomeMaterial.getPrice() );

        return incomeMaterialPostDTO;
    }

    @Override
    public IncomeMaterialGetDTO toGetDTO(IncomeMaterial incomeMaterial) {
        if ( incomeMaterial == null ) {
            return null;
        }

        IncomeMaterialGetDTO incomeMaterialGetDTO = new IncomeMaterialGetDTO();

        incomeMaterialGetDTO.setMaterialGetDTO( materialToMaterialGetDTO( incomeMaterial.getMaterial() ) );
        incomeMaterialGetDTO.setMeasurementDTO( measurementToMeasurementDTO( incomeMaterial.getMeasurement() ) );
        incomeMaterialGetDTO.setId( incomeMaterial.getId() );
        incomeMaterialGetDTO.setIncomeDate( incomeMaterial.getIncomeDate() );
        incomeMaterialGetDTO.setAmount( incomeMaterial.getAmount() );
        incomeMaterialGetDTO.setPrice( incomeMaterial.getPrice()* incomeMaterial.getAmount() );

        return incomeMaterialGetDTO;
    }

    @Override
    public IncomeMaterial toEntity(IncomeMaterialPostDTO incomeMaterialDTO) {
        if ( incomeMaterialDTO == null ) {
            return null;
        }

        IncomeMaterial incomeMaterial = new IncomeMaterial();

        incomeMaterial.setIncomeDate( incomeMaterialDTO.getIncomeDate() );
        incomeMaterial.setAmount( incomeMaterialDTO.getAmount() );
        incomeMaterial.setPrice( incomeMaterialDTO.getPrice() );

        return incomeMaterial;
    }

    @Override
    public List<IncomeMaterialGetDTO> toDTOList(List<IncomeMaterial> incomeMaterialList) {
        if ( incomeMaterialList == null ) {
            return null;
        }

        List<IncomeMaterialGetDTO> list = new ArrayList<IncomeMaterialGetDTO>( incomeMaterialList.size() );
        for ( IncomeMaterial incomeMaterial : incomeMaterialList ) {
            list.add( toGetDTO( incomeMaterial ) );
        }

        return list;
    }

    protected MaterialPostDTO materialToMaterialPostDTO(Material material) {
        if ( material == null ) {
            return null;
        }

        MaterialPostDTO materialPostDTO = new MaterialPostDTO();

        materialPostDTO.setName( material.getName() );

        return materialPostDTO;
    }

    protected MeasurementDTO measurementToMeasurementDTO(Measurement measurement) {
        if ( measurement == null ) {
            return null;
        }

        MeasurementDTO measurementDTO = new MeasurementDTO();

        measurementDTO.setName( measurement.getName() );

        return measurementDTO;
    }

    protected MaterialGetDTO materialToMaterialGetDTO(Material material) {
        if ( material == null ) {
            return null;
        }

        MaterialGetDTO materialGetDTO = new MaterialGetDTO();

        materialGetDTO.setId( material.getId() );
        materialGetDTO.setName( material.getName() );
        materialGetDTO.setAmount( material.getAmount() );
        materialGetDTO.setPrice( material.getPrice() );

        return materialGetDTO;
    }
}
