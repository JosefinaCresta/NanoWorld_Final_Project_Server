package com.ironhack.finalprojectserver.service.impl;

import com.ironhack.finalprojectserver.DTO.ProjectDTO;
import com.ironhack.finalprojectserver.model.Calculator;
import com.ironhack.finalprojectserver.model.Project;
import com.ironhack.finalprojectserver.repository.CalculatorRepository;
import com.ironhack.finalprojectserver.repository.ProjectRepository;
import com.ironhack.finalprojectserver.service.interfaces.ProjectServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class ProjectService implements ProjectServiceInterface {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private CalculatorRepository calculatorRepository;

    public Project findById(Long id) {
        return projectRepository.findById(id).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Project not found"));
    }

    public void saveProject(Project project) {
        if (project.getId() != null) {
            Optional<Project> optionalProject = projectRepository.findById(project.getId());
            if (optionalProject.isPresent())
                throw new ResponseStatusException(
                        HttpStatus.UNPROCESSABLE_ENTITY, "Project with id " + project.getId() + " already exist");
        }
        System.out.println("HERE "+project);
        projectRepository.save(project);
    }

   /* public void update(Long id, Project project) {
        Project projectFromDB = projectRepository.findById(id).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Project is not found"));

        project.setCalculator(projectFromDB.getCalculator());
        projectRepository.save(projectFromDB);
    }*/


    public void update(Long id, Project project) {
        Optional<Project> foundProject = projectRepository.findById(id);
        if(foundProject.isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No Project found with that ID");
        } else {
            if(!project.getTitle().isEmpty()){
                foundProject.get().setTitle(project.getTitle());
                foundProject.get().setDescription(project.getDescription());
                foundProject.get().setCalculator(foundProject.get().getCalculator());
                projectRepository.save(foundProject.get());
            } else {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Author Name cannot be blank");
            }
        }
    }

    public void deleteProject(Long id) {
        Project projectFromDB = projectRepository.findById(id).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Project not found"));
        projectFromDB.setCalculator(null);
        projectRepository.save(projectFromDB);
            projectRepository.deleteById(id);
    }
}
