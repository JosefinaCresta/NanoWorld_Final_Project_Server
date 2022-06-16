package com.ironhack.finalprojectserver.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Nanoparticles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double time;
    private double energy;
    private double eAtomo;
    private int nTotal;
    private int nBulk;
    private int nSurface;
    private int nBond;
    private double avgBonds;


    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="project_id")
    private Project project;
}