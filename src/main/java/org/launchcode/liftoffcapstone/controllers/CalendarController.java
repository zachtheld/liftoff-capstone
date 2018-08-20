package org.launchcode.liftoffcapstone.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("calendar")
public class CalendarController {

    @RequestMapping(value = "")
    public String viewCalendar(Model model, @CookieValue(value = "user", defaultValue = "none") String email) {

        if (email.equals("none")) {
            return "redirect:/login";
        }
        return "calendar/view-calendar";
    }
}
