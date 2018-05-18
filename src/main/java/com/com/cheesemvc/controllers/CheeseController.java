package com.com.cheesemvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;

@Controller
@RequestMapping("cheese")
public class CheeseController {

    static HashMap<String, String> cheeses = new HashMap<>();

    // Request path: /cheese
    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("cheeses", cheeses);
        model.addAttribute("title", "My cheeses");

        return "cheese/index";
    }

    @RequestMapping(value="add", method = RequestMethod.GET)
    public String displayAddCheeseForm(Model model) {
        model.addAttribute("title","Add cheese");
        return "cheese/add";
    }

    @RequestMapping(value="add", method = RequestMethod.POST)
    public String processAddCheeseForm(@RequestParam String cheeseName, @RequestParam String description) {
        cheeses.put(cheeseName, description);
        return "redirect:";
    }

    @RequestMapping(value="remove", method=RequestMethod.GET)
    public String removeCheeseForm(Model model) {
        model.addAttribute("title", "Remove cheese");
        model.addAttribute("cheeses", cheeses);

        return "cheese/remove";
    }

    @RequestMapping(value="remove", method=RequestMethod.POST)
    public String processRemoveCheese(@RequestParam ArrayList<String> cheeseToDelete) {
        for(String c : cheeseToDelete) {
            cheeses.remove(c);
        }

        return "redirect:";
    }

}