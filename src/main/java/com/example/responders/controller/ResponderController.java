package com.example.responders.controller;

import com.example.responders.dto.ResponderDTO;
import com.example.responders.service.ResponderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/responders")
public class ResponderController {

    private final ResponderService responderService;

    public ResponderController(ResponderService responderService) {
        this.responderService = responderService;
    }

    @GetMapping
    public String getAll(Model model){
        model.addAttribute("responders", responderService.getAll());
        return "responders/respondersList";
    }

    @GetMapping("/new")
    public String addNew(Model model){
        model.addAttribute("responder", new ResponderDTO());
        return "responders/responder";
    }

    @PostMapping("/new")
    public String save(Model model , ResponderDTO responderDTO){
    if(responderService.save(responderDTO)){
        return "redirect:/responders";
    }else {
        model.addAttribute("responder" , responderDTO);
    } return "responders/responder";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Long id){
        responderService.deleteById(id);
        return "redirect:/responders";
    }
}
