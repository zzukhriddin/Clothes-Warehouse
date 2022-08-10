package com.sigma.clotheswarehouse.repository;

import com.sigma.clotheswarehouse.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByName(String name);
    Optional<Category> findByIdAndName(Long id, String name);
}
