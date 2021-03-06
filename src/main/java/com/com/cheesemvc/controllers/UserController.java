package com.com.cheesemvc.controllers;

import com.com.cheesemvc.models.User;
import com.com.cheesemvc.models.UserData;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Controller
@RequestMapping("user")
public class UserController {

    @RequestMapping(value = "add", method=RequestMethod.GET)
    public String add(Model model) {

        model.addAttribute("title", "Add User");
        model.addAttribute(new User());

        return "user/add";
    }

    @RequestMapping(value="add", method=RequestMethod.POST)
    public String add(Model model, @Valid @ModelAttribute User user, Errors errors) {

//        model.addAttribute("username", user.getUsername());
//        model.addAttribute("email", user.getEmail());
//        model.addAttribute("password", user.getPassword());
//        model.addAttribute("verify", user.getVerifyPassword());

        if (errors.hasErrors() == true) {
            model.addAttribute(user);
            model.addAttribute("errors", errors);
            return "redirect:";
        }

        if (!user.getPassword().equals(user.getVerifyPassword())) {
            user.setPassword("");
            return "redirect:add";
        }

        if (user.getEmail().length() > 15 || user.getEmail().length() < 5) {
            model.addAttribute("email", "");
            return "redirect:add";
        }

        if (user.getUsername() == "") {
            return "redirect:add";
        }

        if (!user.getUsername().chars().allMatch(Character::isLetter)) {
            model.addAttribute("username", "");
            return "redirect:add";
        }

        UserData.add(user);
        model.addAttribute("users", UserData.getAllUsers());

        return "user/index";

    }

    @RequestMapping(value="/{userId}", method=RequestMethod.GET)
    public String displayUser(Model model, @PathVariable int userId) {
        model.addAttribute("user", UserData.getById(userId));

        return "user/userpage";
    }

}
