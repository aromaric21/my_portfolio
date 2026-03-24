package com.ngportfolio.services.serviceImp;

import com.ngportfolio.entities.Skills;
import com.ngportfolio.repositories.SkillsRepository;
import com.ngportfolio.services.service.SkillsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillsServiceImp implements SkillsService{

    private final SkillsRepository repo;

    public SkillsServiceImp(SkillsRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Skills> getAllSkills() {
        return repo.findAll();
    }
}
