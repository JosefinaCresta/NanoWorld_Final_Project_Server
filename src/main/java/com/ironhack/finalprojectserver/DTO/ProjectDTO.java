package com.ironhack.finalprojectserver.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ironhack.finalprojectserver.model.Calculator;
import com.ironhack.finalprojectserver.model.Cluster;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDTO {
    private String title;
    private String description;
    private Long calculatorId;
    private String creator;
}