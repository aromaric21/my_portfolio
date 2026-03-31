package com.ngportfolio.services.serviceImp;

import com.ngportfolio.entities.Project;
import com.ngportfolio.repositories.ProjectRepository;
import com.ngportfolio.services.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectServiceImp implements ProjectService {

    private final ProjectRepository projectRepo;

    @Override
    public List<Project> getAllProjects() {
        return projectRepo.findAll();
    }

    @Override
    public Project getById(Long id) {
        return projectRepo.findById(id).orElseThrow();
    }

    @Override
    public Project save(Project project) {
        return projectRepo.save(project);
    }

    @Override
    public Project update(Long id, Project project) {
        Project existing = projectRepo.findById(id).orElseThrow();
        existing.setTitle(project.getTitle());
        existing.setDescription(project.getDescription());
        existing.setLink(project.getLink());
        existing.setTechnologies(project.getTechnologies());
        return projectRepo.save(existing);
    }

    @Override
    public void delete(Long id) {
        projectRepo.deleteById(id);
    }
}
