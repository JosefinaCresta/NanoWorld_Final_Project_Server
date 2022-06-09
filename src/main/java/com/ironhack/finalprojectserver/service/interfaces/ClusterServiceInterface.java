package com.ironhack.finalprojectserver.service.interfaces;


import com.ironhack.finalprojectserver.DTO.ClusterDTO;

public interface ClusterServiceInterface {

    void saveCluster(ClusterDTO cluster);

    void deleteCluster(Long id);
}
