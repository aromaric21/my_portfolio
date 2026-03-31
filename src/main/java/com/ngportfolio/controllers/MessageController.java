package com.ngportfolio.controllers;

import com.ngportfolio.entities.Message;
import com.ngportfolio.services.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/messages")
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;

    //http://localhost:8080/messages
    @GetMapping
    public String listMessages(Model model) {
        model.addAttribute("message", messageService.getAllMessages());
        return "messages/index";
    }

    @GetMapping("/new")
    public String newMessageForm(Model model) {
        model.addAttribute("message", new Message());
        return "messages/form";
    }

    @PostMapping
    public String saveMessage(@ModelAttribute Message message,
                              RedirectAttributes redirectAttributes) {
        messageService.save(message);
        redirectAttributes.addFlashAttribute("messageSuccess",
                "Message envoyé avec succès !");
        return "redirect:/messages";
    }

    @GetMapping("/edit/{id}")
    public String editMessageForm(@PathVariable Long id, Model model) {
        model.addAttribute("message", messageService.getById(id));
        return "messages/form";
    }

    @PostMapping("/update/{id}")
    public String updateMessage(@PathVariable Long id, @ModelAttribute Message message,
                                RedirectAttributes redirectAttributes) {
        messageService.update(id, message);
        redirectAttributes.addFlashAttribute("messageSuccess", "✏️ Message modifié avec succès !");
        return "redirect:/messages";
    }

    @GetMapping("/delete/{id}")
    public String deleteMessage(@PathVariable Long id,
                                RedirectAttributes redirectAttributes) {
        messageService.delete(id);
        redirectAttributes.addFlashAttribute("messageSuccess", "🗑️ Message supprimé avec succès !");
        return "redirect:/messages";
    }
}
