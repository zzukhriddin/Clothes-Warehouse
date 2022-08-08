package com.sigma.clotheswarehouse.repository;

import com.sigma.clotheswarehouse.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
