package com.sigma.clotheswarehouse.mapper;

import com.sigma.clotheswarehouse.entity.Measurement;
import com.sigma.clotheswarehouse.payload.MeasurementDTO;
import com.sigma.clotheswarehouse.repository.MeasurementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class MeasurementMapper {

    private final MeasurementRepository measurementRepository;


    public Measurement measurementDTOToMeasurement(MeasurementDTO measurementDTO) {
        Measurement measurement = new Measurement();
        Optional<Measurement> optionalMeasurement = measurementRepository.findByName(measurementDTO.getName());
        if (optionalMeasurement.isPresent())
            measurement = optionalMeasurement.get();
        measurement.setName(measurementDTO.getName());

        // Saving measurement
        return measurementRepository.save(measurement);
    }
}
