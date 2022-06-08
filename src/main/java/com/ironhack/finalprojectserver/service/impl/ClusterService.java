package com.ironhack.finalprojectserver.service.impl;

import com.ironhack.finalprojectserver.DTO.ClusterDTO;
import com.ironhack.finalprojectserver.model.Cluster;
import com.ironhack.finalprojectserver.repository.ClusterRepository;
import com.ironhack.finalprojectserver.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClusterService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ClusterRepository clusterRepository;

    public void saveCluster(ClusterDTO cluster){
        Cluster newCluster = new Cluster();
        newCluster.setFormula(cluster.getFormula());
        newCluster.setNatom(cluster.getNatom());
        newCluster.setEnergy(cluster.getEnergy());
        newCluster.setForces(cluster.getForces());
        newCluster.setMagmon(cluster.getMagmon());
        newCluster.setProject(projectRepository.findById(cluster.getProjectId()).get());
        clusterRepository.save(newCluster);
    }
}
