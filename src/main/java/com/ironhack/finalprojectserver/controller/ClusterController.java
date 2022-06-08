package com.ironhack.finalprojectserver.controller;

import com.ironhack.finalprojectserver.DTO.ClusterDTO;
import com.ironhack.finalprojectserver.service.impl.ClusterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ClusterController {
    @Autowired
    private ClusterService clusterService;

    @PostMapping("/clusters")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveCluster(@RequestBody ClusterDTO cluster){
        clusterService.saveCluster(cluster);
    }
}
