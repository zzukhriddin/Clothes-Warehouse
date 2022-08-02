package com.sigma.clotheswarehouse.repository;

import com.sigma.clotheswarehouse.entity.Measurement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MeasurementRepository extends JpaRepository<Measurement, Long> {

    Optional<Measurement> findByName(String name);
}
