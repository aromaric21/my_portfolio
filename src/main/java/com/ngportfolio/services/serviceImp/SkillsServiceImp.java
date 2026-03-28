package com.ngportfolio.services.serviceImp;

import com.ngportfolio.entities.Skills;
import com.ngportfolio.repositories.SkillsRepository;
import com.ngportfolio.services.service.SkillsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SkillsServiceImp implements SkillsService{

    private final SkillsRepository skillsRepo;

    @Override
    public List<Skills> getAllSkills() {
        return skillsRepo.findAll();
    }

    @Override
    public Skills getById(Long id) {
        return skillsRepo.findById(id).orElseThrow();
    }

    @Override
    public Skills save(Skills skills) {
        return skillsRepo.save(skills);
    }

    @Override
    public Skills update(Long id, Skills skills) {
        Skills existing = skillsRepo.findById(id).orElseThrow();
        existing.setName(skills.getName());
        existing.setGraduate(skills.getGraduate());
        existing.setCategory(skills.getCategory());
        return skillsRepo.save(existing);
    }

    @Override
    public void delete(Long id) {
        skillsRepo.deleteById(id);
    }
}
