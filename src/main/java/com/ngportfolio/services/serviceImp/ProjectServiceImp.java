package com.ngportfolio.services.serviceImp;

import com.ngportfolio.entities.Project;
import com.ngportfolio.repositories.ProjectRepository;
import com.ngportfolio.services.service.ProjectService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImp implements ProjectService {

    private final ProjectRepository repo;

    public ProjectServiceImp(ProjectRepository repo) {
        this.repo = repo;
    }


    @Override
    public List<Project> getAllProjects() {
        return repo.findAll();
    }
}
