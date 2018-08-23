package org.launchcode.liftoffcapstone.controllers;


import org.launchcode.liftoffcapstone.models.Reviews;
import org.launchcode.liftoffcapstone.models.User;
import org.launchcode.liftoffcapstone.models.data.ReviewsDao;
import org.launchcode.liftoffcapstone.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("")
public class ReviewController {

    @Autowired
    UserDao userdao;

    @Autowired
    ReviewsDao reviewsDao;

    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String createReview(Model model, @CookieValue(value = "user", defaultValue = "none") String email) {

        if (email.equals("none")) {
            return "redirect:/login";
        }


        return "review/create";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String processCreateReview(Model model, @ModelAttribute Reviews reviews, @CookieValue(value = "user", defaultValue = "none") String email) {

        if (email.equals("none")) {
            return "redirect:/login";
        }
        User u = userdao.findByEmail(email).get(0);
        reviews.setUser(u);
        reviewsDao.save(reviews);
        return "redirect:/review-list";
    }

    @RequestMapping("review-list")
    public String listReviews(Model model, @ModelAttribute Reviews reviews , @CookieValue(value = "user", defaultValue = "none") String email) {
        model.addAttribute("reviewData", reviewsDao.findAll());
        return "review/list";
    }
}
