package com.sigma.clotheswarehouse.repository;

import com.sigma.clotheswarehouse.entity.Client;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {
    boolean findByPhoneNumber(String phoneNumber);
}
