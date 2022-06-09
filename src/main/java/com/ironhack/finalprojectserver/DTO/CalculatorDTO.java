package com.ironhack.finalprojectserver.DTO;

import com.ironhack.finalprojectserver.model.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ElementCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CalculatorDTO {
    private String xc;
    private boolean lreal=false;
    @ElementCollection
    private List<Integer> kpts;
    private int ibrion;
    private double encut;
    private double ediffg;
    private int nsw;
    private int ispin;
    private int ncore;
    private String command;


}