package com.ngportfolio.controllers;

import com.ngportfolio.entities.Project;
import com.ngportfolio.services.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/projects")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    //http://localhost:8080/projects
    @GetMapping
    public String listProjects(Model model) {
        model.addAttribute("projects", projectService.getAllProjects());
        return "projects/index";
    }

    @GetMapping("/new")
    public String newProjectForm(Model model) {
        model.addAttribute("project", new Project());
       return "projects/form";
    }

    @PostMapping
    public String saveProject(@ModelAttribute Project project,
                              RedirectAttributes redirectAttributes){
        projectService.save(project);
        redirectAttributes.addFlashAttribute("message",
                "Projet ajouté avec succès!");
        return "redirect:/projects";
    }

    @GetMapping("edit/{id}")
    public String editProjectForm(@PathVariable Long id, Model model){
        model.addAttribute("project", projectService.getById(id));
        return "projects/form";
    }

    @PostMapping("/update/{id}")
    public String updateProject(@PathVariable Long id, Project project,
                                RedirectAttributes redirectAttributes){
        projectService.update(id, project);
        redirectAttributes.addFlashAttribute("message",
                "Projet modifié avec succès !");
        return "redirect:/projects";
    }

    @GetMapping("/delete/{id}")
    public String deleteProject(@PathVariable Long id,
                                RedirectAttributes redirectAttributes){
        projectService.delete(id);
        redirectAttributes.addFlashAttribute("message", "🗑️Projet supprimé avec succès !");
        return "redirect:/projects";
    }

}
