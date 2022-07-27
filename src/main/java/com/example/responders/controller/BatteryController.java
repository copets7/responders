package com.example.responders.controller;

import com.example.responders.service.BatteryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/batteries")
public class BatteryController {

    private final BatteryService batteryService;

    public BatteryController(BatteryService batteryService) {
        this.batteryService = batteryService;
    }

    @GetMapping
    public String getAll(Model model){
        model.addAttribute("batteries", batteryService.getAll());
        return "batteries/batteryList";
    }
}
