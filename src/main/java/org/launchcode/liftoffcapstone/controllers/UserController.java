package org.launchcode.liftoffcapstone.controllers;


import org.launchcode.liftoffcapstone.models.User;
import org.launchcode.liftoffcapstone.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;


@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "register", method = RequestMethod.GET)
    public String registerForm(Model model) {
        model.addAttribute("title", "Register");
        //userDao.save();

        return "user/register";
    }
    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String processRegisterForm(Model model, @ModelAttribute User newUser, String verify) {
        if (verify.equals(newUser.getPassword())) {
            userDao.save(newUser);

        } else {
            model.addAttribute("name", newUser.getName());
            model.addAttribute("email", newUser.getEmail());
            model.addAttribute("title", "Register");
            return "redirect:/user/register";
        }
        model.addAttribute("title", "Welcome");
        return "user/registered";
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String loginForm(Model model) {
        model.addAttribute("title", "Login");

        return "user/login";
    }
}
