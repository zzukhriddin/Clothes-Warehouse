package com.sigma.clotheswarehouse.repository;

import com.sigma.clotheswarehouse.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
