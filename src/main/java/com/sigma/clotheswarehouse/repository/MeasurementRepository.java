package com.sigma.clotheswarehouse.repository;

import com.sigma.clotheswarehouse.entity.Measurement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeasurementRepository extends JpaRepository<Measurement, Long> {
}
