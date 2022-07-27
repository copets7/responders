package com.example.responders.controller;

import com.example.responders.service.SuperCapacitorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/capacitors")
public class SuperCapacitorController {

    private final SuperCapacitorService superCapacitorService;

    public SuperCapacitorController(SuperCapacitorService superCapacitorService) {
        this.superCapacitorService = superCapacitorService;
    }
    @GetMapping
    public String getAll(Model model){
        model.addAttribute("capacitors", superCapacitorService.getAll());
        return "capacitors/capacitorsList";
    }

}
