package com.ngportfolio.services.service;

import com.ngportfolio.entities.Project;
import com.ngportfolio.repositories.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    private final ProjectRepository repo;


    public ProjectService(ProjectRepository repo) {
        this.repo = repo;
    }

    public List<Project> getAllProjects(){
        return repo.findAll();
    }
}
