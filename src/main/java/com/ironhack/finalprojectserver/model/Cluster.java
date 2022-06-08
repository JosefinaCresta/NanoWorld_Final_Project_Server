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
public class Cluster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String formula;
    private int natom;
    private float energy;
    private float forces;
    private float magmon;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="project_id")
    private Project project;
}