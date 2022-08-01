package com.sigma.clotheswarehouse.repository;

import com.sigma.clotheswarehouse.entity.ProductHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductHistoryRepository extends JpaRepository<ProductHistory, UUID> {
}
