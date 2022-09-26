package com.ardecs.smarthome.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/detector")
public class DetectorController {
    @PostMapping("/create")
    public String create(@RequestParam("owner_email") String email,
                         @RequestParam("location_id") String location,
                         @RequestParam("description") String description,
                         @RequestParam("name") String name,
                         Model model) {
        model.addAttribute("message", "detector was created.");
        return "";
    }
}
