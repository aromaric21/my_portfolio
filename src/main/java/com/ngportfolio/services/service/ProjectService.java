package com.ngportfolio.services.service;

import com.ngportfolio.entities.Project;


import java.util.List;

public interface ProjectService {

    // List of projects
    List<Project> getAllProjects();
    Project getById(Long id);
    Project save(Project project);
    // Update a project
    Project update(Long id, Project project);
    // Delete a project
    void delete(Long id);
}
