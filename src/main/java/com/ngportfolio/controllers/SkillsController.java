package com.ngportfolio.controllers;

import com.ngportfolio.services.service.ProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/skills")
public class SkillsController {

    private final ProjectService service;

    public SkillsController(ProjectService service) {
        this.service = service;
    }

    //http://localhost:8080/skills
    @GetMapping
    public String index() {
        // Spring Boot va chercher templates/projects/index.html
        return "skills/index";
    }

}
