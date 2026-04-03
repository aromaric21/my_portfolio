package com.ngportfolio.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CVController {

    @GetMapping("/cv")
    public String cv(Model model) {
        model.addAttribute("pageTitle", "Mon CV - Portfolio");
        return "cv";
    }
}
