package com.sigma.clotheswarehouse.repository;

import com.sigma.clotheswarehouse.entity.IncomeMaterial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IncomeMaterialRepository extends JpaRepository<IncomeMaterial, UUID> {
}
