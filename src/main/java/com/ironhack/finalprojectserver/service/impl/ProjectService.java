package com.ironhack.finalprojectserver.service.impl;

import com.ironhack.finalprojectserver.model.Project;
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
        projectRepository.save(project);
    }

    public void update(Long id, Project project) {
        Project projectFromDB = projectRepository.findById(id).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Project is not found"));
        project.setId(projectFromDB.getId());
        projectRepository.save(project);
    }

    public void deleteProject(Long id) {
        Project projectFromDB = projectRepository.findById(id).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Project not found"));
        projectRepository.deleteById(id);
    }
}
