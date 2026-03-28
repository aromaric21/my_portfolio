package com.ngportfolio.controllers;

import com.ngportfolio.entities.Skills;
import com.ngportfolio.services.service.SkillsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/skills")
@RequiredArgsConstructor
public class SkillsController {

    private final SkillsService skillsService;

    //http://localhost:8080/skills
    @GetMapping
    public String listSkills(Model model){
        model.addAttribute("skills", skillsService.getAllSkills());
        return "skills/index";
    }

    @GetMapping("/new")
    public String newSkillForm(Model model){
        model.addAttribute("skills", new Skills());
        return "skills/form";
    }

    @PostMapping
    public String saveSkill(@ModelAttribute Skills skills,
                            RedirectAttributes redirectAttributes){
        skillsService.save(skills);
        redirectAttributes.addFlashAttribute("message",
                "Compétence ajoutée avec succès !");
        return "redirect:/skills";
    }

    @GetMapping("/edit/{id}")
    public String editSkillForm(@PathVariable Long id, Model model){
        model.addAttribute("skills", skillsService.getById(id));
        return "skills/form";
    }

    @PostMapping("/update/{id}")
    public String updateSkill(@PathVariable Long id, @ModelAttribute Skills skills,
                              RedirectAttributes redirectAttributes){
        skillsService.update(id, skills);
        redirectAttributes.addFlashAttribute("message",
                "Compétence modifiée avec succès");
        return "redirect:/skills";
    }

    @GetMapping("/delete/{id}")
    public String deleteSkill(@PathVariable Long id,
                              RedirectAttributes redirectAttributes){
        skillsService.delete(id);
        redirectAttributes.addFlashAttribute("message",
                "un compétence à été supprimer avec succès !");
        return "redirect:/skills";
    }
}
