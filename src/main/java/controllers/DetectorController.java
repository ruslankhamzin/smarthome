package controllers;

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
        model.addAttribute("id", detector.getId);
        model.addAttribute("owner_email", detector.getOwnerEmail);
        model.addAttribute("location_id", detector.getLocationId);
        model.addAttribute("description", detector.getDescription);
        model.addAttribute("name", detector.getName);
        model.addAttribute("registration_date", detector.getRegistrationDate);
        model.addAttribute("last_active_date", detector.getLastActiveDate);
        model.addAttribute("active", detector.getActive);
        model.addAttribute("message", "notification has been sent.");
        return "";
    }
}
