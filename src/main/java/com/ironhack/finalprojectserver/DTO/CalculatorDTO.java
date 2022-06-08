package com.ironhack.finalprojectserver.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CalculatorDTO {
    private String xc;
    private boolean lreal=false;
    private Integer kpts;
    private boolean gamma;
    private int ibrion;
    private float encut;
    private float ediffg;
    private int nsw;
    private int ispin;
    private int ncore;
    private String command;


}