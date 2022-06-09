package com.ironhack.finalprojectserver.controller;

import com.ironhack.finalprojectserver.DTO.ClusterDTO;
import com.ironhack.finalprojectserver.model.Calculator;
import com.ironhack.finalprojectserver.model.Cluster;
import com.ironhack.finalprojectserver.repository.ClusterRepository;
import com.ironhack.finalprojectserver.service.impl.ClusterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ClusterController {
    @Autowired
    private ClusterService clusterService;

    @Autowired
    private ClusterRepository clusterRepository;

    @GetMapping("/clusters")
    @ResponseStatus(HttpStatus.OK)
    public List<Cluster> getClusters() {
        return clusterRepository.findAll();
    }

    @PostMapping("/clusters")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveCluster(@RequestBody ClusterDTO cluster){
        clusterService.saveCluster(cluster);
    }

    @DeleteMapping("/clusters/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCluster(@PathVariable Long id){
        clusterService.deleteCluster(id);
    }
}

