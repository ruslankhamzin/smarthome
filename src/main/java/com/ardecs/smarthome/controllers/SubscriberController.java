package com.ardecs.smarthome.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/subscriber")
public class SubscriberController {
    @PostMapping("/subscribe")
    public String subscribe(@RequestParam("detector_id") String id,
                            @RequestParam("owner_email") String email,
                            Model model) {
        model.addAttribute("message", "subscribe request sent");
        return "";
    }
}
