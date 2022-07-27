package com.example.responders.controller;

import com.example.responders.service.ChokeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/chokes")
public class ChokeController {

    private final ChokeService chokeService;

    public ChokeController(ChokeService chokeService) {
        this.chokeService = chokeService;
    }

    @GetMapping
    public String getAll(Model model){
        model.addAttribute("chokes",chokeService.getAll());
        return "chokes/chokesList";
    }
}
