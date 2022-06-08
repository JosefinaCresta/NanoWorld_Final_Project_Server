package com.ironhack.finalprojectserver.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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
    private Integer kpts;
    private boolean gamma;
    private int ibrion;
    private float encut;
    private float ediffg;
    private int nsw;
    private int ispin;
    private int ncore;
    private String command;

    @OneToMany(mappedBy = "calculator")
    private List<Project> projects;
}