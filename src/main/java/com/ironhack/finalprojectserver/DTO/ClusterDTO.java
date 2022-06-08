package com.ironhack.finalprojectserver.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClusterDTO {
    private String formula;
    private int natom;
    private float energy;
    private float forces;
    private float magmon;
    private Long projectId;
}
