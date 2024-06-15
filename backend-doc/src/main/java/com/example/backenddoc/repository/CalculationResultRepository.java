package com.example.backenddoc.repository;

import com.example.backenddoc.entity.CalculationResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalculationResultRepository extends JpaRepository<CalculationResult, Long> {
}