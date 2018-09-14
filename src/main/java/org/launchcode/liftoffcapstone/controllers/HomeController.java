package org.launchcode.liftoffcapstone.controllers;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class HomeController {

    @RequestMapping(value = "")
    public String home(Model model) {
        model.addAttribute("title", "Welcome To St. Louis Dog Sitting");

        return "home/index";
    }
    @RequestMapping(value = "services")
    public String services(Model model) {
        model.addAttribute("title", "Services");
        return "about/services";
    }

    @RequestMapping(value = "message")
    public String message(Model model) {
        return "message/email";
    }

}
