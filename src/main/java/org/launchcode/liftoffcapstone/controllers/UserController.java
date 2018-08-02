package org.launchcode.liftoffcapstone.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;


@Controller
@RequestMapping("user")
public class UserController {

    static ArrayList<String> user = new ArrayList<>();

    @RequestMapping(value = "register", method = RequestMethod.GET)
    public String registerForm(Model model) {
        model.addAttribute("title", "Register");

        return "user/register";
    }
    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String processRegisterForm(@RequestParam String name, Model model) {
        user.add(name);
        model.addAttribute("title", "Welcome");
        return "user/registered";
    }
}
