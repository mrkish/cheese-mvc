package com.com.cheesemvc.controllers;

import com.com.cheesemvc.models.User;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("user")
public class UserController {

    @RequestMapping(value = "add", method=RequestMethod.GET)
    public String add(Model model) {

        return "user/add";
    }

    @RequestMapping(value="add", method=RequestMethod.POST)
    public String add(Model model, @ModelAttribute User user, String verify) {

        String userPassword = user.getPassword();

        if (!userPassword.equals(verify)) {
            return "redirect:add";
        }

        if (user.getEmail().length() > 15 || user.getEmail().length() < 5) {
            return "redirect:add";
        }

        if (!user.getUsername().chars().allMatch(Character::isLetter)) {
            return "redirect:add";
        }

        return "user/index";

    }

}
