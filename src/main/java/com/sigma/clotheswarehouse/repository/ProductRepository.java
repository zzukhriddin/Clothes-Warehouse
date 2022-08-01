package com.sigma.clotheswarehouse.repository;

import com.sigma.clotheswarehouse.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
}
