package com.ironhack.finalprojectserver.repository;

import com.ironhack.finalprojectserver.model.Cluster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClusterRepository extends JpaRepository<Cluster, Long> {
}
