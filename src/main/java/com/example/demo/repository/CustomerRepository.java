package com.example.demo.repository;

import com.example.demo.entity.ECustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<ECustomer, String> {

    boolean existsByCard(String card);

    boolean existsByPassport(String s);

    Optional<ECustomer> findByCard(String card);

    void deleteByCard(String card);
}
