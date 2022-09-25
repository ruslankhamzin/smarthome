package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

@Controller
@RequestMapping(value = "/notification")
public class NotificationController {
    @PostMapping("/send")
    public String send(@RequestParam("detector_id") String id,
                       @RequestParam("type") String type,
                       @RequestParam("date") LocalDateTime dateTime,
                       Model model) {
        model.addAttribute("message", "notification has been sent.");
        return "";
    }

}
