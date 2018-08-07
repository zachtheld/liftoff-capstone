package org.launchcode.liftoffcapstone.controllers;


import org.launchcode.liftoffcapstone.models.Dog;
import org.launchcode.liftoffcapstone.models.User;
import org.launchcode.liftoffcapstone.models.data.DogDao;
import org.launchcode.liftoffcapstone.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("petinformation")
public class PetInfoController {

    @Autowired
    private UserDao userDao;
    @Autowired
    private DogDao dogDao;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String petInfoForm(Model model, @CookieValue(value = "user", defaultValue = "none") String email) {

        if(email.equals("none")) {
            return "redirect:/user/login";
        }
        User u = userDao.findByEmail(email).get(0);

        model.addAttribute("title", "Add Information About Your Dog");

        return "petinformation/add";
    }
    @RequestMapping(value = "", method = RequestMethod.POST)
    public String processPetInfoForm(Model model, @ModelAttribute Dog dog, @CookieValue(value = "user", defaultValue = "none") String email){

        if(email.equals("none")) {
            return "redirect:/user/login";
        }
        User u = userDao.findByEmail(email).get(0);

        dog.setUser(u);
        dogDao.save(dog);

        return "redirect:petinformation/list";
    }

    @RequestMapping(value = "list")
    public String listInfo(Model model, @CookieValue(value = "user", defaultValue = "none") String email) {

        if(email.equals("none")) {
            return "redirect:/user/login";
        }
        User u = userDao.findByEmail(email).get(0);
        model.addAttribute("dogdata", u.getDogs());
        model.addAttribute("title", "Pet Information");

        return "petinformation/listinformation";
    }

}
