package com.ironhack.finalprojectserver.service.interfaces;

import com.ironhack.finalprojectserver.model.Project;

public interface ProjectServiceInterface {
    Project findById(Long id);
    void saveProject(Project project);
    void update(Long id, Project project);
    void deleteProject(Long id);
}
