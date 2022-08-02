package com.sigma.clotheswarehouse.repository;

import com.sigma.clotheswarehouse.entity.Material;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface MaterialRepository extends JpaRepository<Material, UUID> {

    Optional<Material> findByName(String name);
}
