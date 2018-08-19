package org.launchcode.liftoffcapstone.controllers;


import org.launchcode.liftoffcapstone.models.User;
import org.launchcode.liftoffcapstone.models.UserInfo;
import org.launchcode.liftoffcapstone.models.data.UserDao;
import org.launchcode.liftoffcapstone.models.data.UserInfoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


@Controller
@RequestMapping("")
public class UserController {

    @Autowired
    UserDao userDao;

    @Autowired
    UserInfoDao userInfoDao;

    @RequestMapping(value = "register", method = RequestMethod.GET)
    public String registerForm(Model model) {
        model.addAttribute("title", "Register");


        return "user/register";
    }
    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String processRegisterForm(Model model, @ModelAttribute User newUser, String verify) {
        List<User> sameName = userDao.findByEmail(newUser.getEmail());
        if (verify.equals(newUser.getPassword())) {
            userDao.save(newUser);


        } else {
           // model.addAttribute("name", newUser.getName());
            model.addAttribute("email", newUser.getEmail());
            model.addAttribute("title", "Register");
            return "redirect:/register";
        }
        model.addAttribute("title", "Welcome");

        return "user/registered";
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String loginForm(Model model) {
        model.addAttribute("title", "Login");

        return "user/login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String processLoginForm(Model model, @ModelAttribute User user, HttpServletResponse response) {

        List<User> userList = userDao.findByEmail(user.getEmail());
        if (userList.isEmpty()) {
            model.addAttribute("title","Login");
            return "user/login";
        }
        User loggedin = userList.get(0);
        if (loggedin.getPassword().equals(user.getPassword())) {
            Cookie c = new Cookie("user", user.getEmail());
            c.setPath("/");
            response.addCookie(c);

            return "redirect:/user-information/add";

        }
        return "user/login";
    }
    @RequestMapping(value = "logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                c.setMaxAge(0);
                c.setPath("/");
                response.addCookie(c);
            }

        }
        return "user/login";
    }


}
