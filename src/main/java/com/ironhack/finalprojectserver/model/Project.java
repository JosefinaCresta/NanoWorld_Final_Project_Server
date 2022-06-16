package com.ironhack.finalprojectserver.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Provide a title")
    private String title;
    @NotEmpty(message = "Provide a description")
    private String description;

    private String creator;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="calculator_id", nullable = true)
    private Calculator calculator;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Cluster> clusters;

    public Project(String title, String description, String creator, Calculator calculator) {
        this.title = title;
        this.description = description;
        this.creator = creator;
        this.calculator = calculator;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", creator='" + creator + '\'' +
                ", calculator=" + calculator +
                '}';
    }
}