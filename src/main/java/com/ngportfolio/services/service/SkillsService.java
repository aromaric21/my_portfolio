package com.ngportfolio.services.service;

import com.ngportfolio.entities.Skills;

import java.util.List;

public interface SkillsService {

    List<Skills> getAllSkills();
    Skills getById(Long id);
    Skills save(Skills skill);
    Skills update(Long id, Skills skill);
    void delete(Long id);

}
