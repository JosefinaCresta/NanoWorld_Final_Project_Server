package com.ironhack.finalprojectserver.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Calculator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String xc;
    private boolean lreal;
    @ElementCollection
    private List<Integer> kpts;
    private int ibrion;
    private double encut;
    private double ediffg;
    private int nsw;
    private int ispin;
    private int ncore;
    private String command;

    @JsonIgnore
    @OneToMany(mappedBy = "calculator",  fetch = FetchType.EAGER, orphanRemoval = true)
    private List<Project> projects;

    public Calculator(String xc, boolean lreal, int ibrion, double encut, double ediffg, int nsw, int ispin, int ncore, String command) {
        this.xc = xc;
        this.lreal = lreal;
        this.ibrion = ibrion;
        this.encut = encut;
        this.ediffg = ediffg;
        this.nsw = nsw;
        this.ispin = ispin;
        this.ncore = ncore;
        this.command = command;
    }
}

