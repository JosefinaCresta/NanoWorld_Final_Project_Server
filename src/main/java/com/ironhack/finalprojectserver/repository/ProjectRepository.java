package com.ironhack.finalprojectserver.repository;

import com.ironhack.finalprojectserver.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    Integer countByCalculatorId(Long calculatorId);
}
