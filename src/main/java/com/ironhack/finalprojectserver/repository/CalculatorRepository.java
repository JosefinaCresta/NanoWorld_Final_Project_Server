package com.ironhack.finalprojectserver.repository;

import com.ironhack.finalprojectserver.model.Calculator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalculatorRepository extends JpaRepository<Calculator, Long> {
}
