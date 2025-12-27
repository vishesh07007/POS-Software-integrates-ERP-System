package com.software.ERP.controllers;

import ch.qos.logback.core.model.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class homeController {

    @GetMapping("/home")
    public String home() {

        return "home";
    }

    @GetMapping("/about")
    public String about() {

        return "about";
    }

    @GetMapping("/location")
    public String location() {

        return "Locate_us";
    }

    @GetMapping("/contact")
    public String contact() {

        return "contact_us";
    }

    @GetMapping("/login")
    public String login(Model model) {

        model.addAttribute("adminLogin",new AdminLogin());
        return "login";

    }

}
