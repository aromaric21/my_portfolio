package com.ngportfolio.controllers;

import com.ngportfolio.services.service.ProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/projects")
public class ProjectController {

    private final ProjectService service;

    public ProjectController(ProjectService service) {
        this.service = service;
    }

    //http://localhost:8080/projects
    @GetMapping
    public String index() {
        // Spring Boot va chercher templates/projects/index.html
        return "projects/index";
    }

    //http://localhost:8080/projects
//    @GetMapping
//    public String listProjects(Model model) {
//        model.addAttribute("projects", service.getAllProjects());
//       return "projects/index";
//    }
}
