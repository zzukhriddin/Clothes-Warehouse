package com.sigma.clotheswarehouse.repository;

import com.sigma.clotheswarehouse.entity.OutcomeMaterial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OutcomeMaterialRepository extends JpaRepository<OutcomeMaterial, UUID> {
}
