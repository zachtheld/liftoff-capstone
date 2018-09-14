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

@Controller
@RequestMapping(value = "user-information")
public class UserInfoController {

    @Autowired UserDao userDao;

    @Autowired UserInfoDao userInfoDao;

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String addInformation(Model model, @CookieValue(value = "user", defaultValue = "none") String email) {
        if(email.equals("none")) {
            return "redirect:/login";
        }

        return "user/add-information";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddInformation(Model model, @ModelAttribute UserInfo userInfo,
                                        @CookieValue(value = "user", defaultValue = "none") String email) {
        if (email.equals("none")) {
            return "redirect:/login";
        }
        User u = userDao.findByEmail(email).get(0);

        userInfo.setUser(u);
        userInfoDao.save(userInfo);

        return "redirect:/user-information/view";

    }

    @RequestMapping(value = "view")
    public String viewUserInfo(Model model, @CookieValue(value = "user", defaultValue = "none") String email) {

        if (email.equals("none")) {
            return "redirect:/login";
        }
        User u = userDao.findByEmail(email).get(0);
        model.addAttribute("userData", u.getUserInfos());
        return "user/view-information";

    }
}
