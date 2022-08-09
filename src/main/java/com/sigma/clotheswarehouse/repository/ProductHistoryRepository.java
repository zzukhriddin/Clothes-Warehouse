package com.sigma.clotheswarehouse.repository;

import com.sigma.clotheswarehouse.entity.ProductHistory;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

public interface ProductHistoryRepository extends JpaRepository<ProductHistory, UUID> {

    List<ProductHistory> getAllByDateBetween(Timestamp date, Timestamp date2, Sort descending);
}
