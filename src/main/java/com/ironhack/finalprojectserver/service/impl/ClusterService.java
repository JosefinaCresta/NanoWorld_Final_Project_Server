package com.ironhack.finalprojectserver.service.impl;

import com.ironhack.finalprojectserver.DTO.ClusterDTO;
import com.ironhack.finalprojectserver.model.Calculator;
import com.ironhack.finalprojectserver.model.Cluster;
import com.ironhack.finalprojectserver.repository.ClusterRepository;
import com.ironhack.finalprojectserver.repository.ProjectRepository;
import com.ironhack.finalprojectserver.service.interfaces.ClusterServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ClusterService implements ClusterServiceInterface {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ClusterRepository clusterRepository;

    public void saveCluster(ClusterDTO cluster){
        Cluster newCluster = new Cluster();
        newCluster.setFormula(cluster.getFormula());
        newCluster.setNatoms(cluster.getNatoms());
        newCluster.setEnergy(cluster.getEnergy());
        newCluster.setForces(cluster.getForces());
        newCluster.setMag(cluster.getMag());
        newCluster.setProject(projectRepository.findById(cluster.getProjectId()).get());
        clusterRepository.save(newCluster);
    }

    public void deleteCluster(Long id) {
        Cluster clusterFromDB = clusterRepository.findById(id).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Cluster not found"));
    }
}
