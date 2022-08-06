package com.sigma.clotheswarehouse.repository;

import com.sigma.clotheswarehouse.entity.ResourceForOutcomeMaterial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ResourceForOutcomeMaterialRepository extends JpaRepository<ResourceForOutcomeMaterial, UUID> {
}
