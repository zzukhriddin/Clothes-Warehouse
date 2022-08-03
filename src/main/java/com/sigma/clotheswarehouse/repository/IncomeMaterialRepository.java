package com.sigma.clotheswarehouse.repository;

import com.sigma.clotheswarehouse.entity.IncomeMaterial;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Timestamp;
import java.util.UUID;

public interface IncomeMaterialRepository extends JpaRepository<IncomeMaterial, UUID> {

    Page<IncomeMaterial> findAllByIncomeDateBetween(Timestamp startDate, Timestamp endDate,
                                                          Pageable pageable);
}
