package com.example.demo.repository;

import com.example.demo.entity.ESupplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SupplierRepository extends JpaRepository<ESupplier, String> {

    Optional<ESupplier> findByName(String name);
}
