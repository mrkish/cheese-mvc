package com.com.cheesemvc.controllers;

import com.com.cheesemvc.models.Cheese;
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

    //static HashMap<String, String> cheeses = new HashMap<>();
    static ArrayList<Cheese> cheeses = new ArrayList<>();
    static HashMap<String, String> errors = new HashMap<>();

    // Request path: /cheese
    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("cheeses", cheeses);
        model.addAttribute("title", "My cheeses");
        model.addAttribute("errors", errors);

        return "cheese/index";
    }

    @RequestMapping(value="add", method = RequestMethod.GET)
    public String displayAddCheeseForm(Model model) {
        model.addAttribute("title","Add cheese");
        model.addAttribute("errors", errors);

        return "cheese/add";
    }

    @RequestMapping(value="add", method = RequestMethod.POST)
    public String processAddCheeseForm(@RequestParam String cheeseName, @RequestParam String description) {

        if (!cheeseName.chars().allMatch(Character::isLetter)) {
            String cheeseNameError = "Invalid cheese name!";
            errors.put("cheeseNameError", cheeseNameError);
            return "redirect:add";
        }

        //cheeses.put(cheeseName, description);
        Cheese newCheese = new Cheese(cheeseName, description);
        cheeses.add(newCheese);
        return "redirect:";
    }

    @RequestMapping(value="remove", method=RequestMethod.GET)
    public String removeCheeseForm(Model model) {
        model.addAttribute("title", "Remove cheese");
        model.addAttribute("cheeses", cheeses);
        model.addAttribute("errors", errors);

        return "cheese/remove";
    }

    @RequestMapping(value="remove", method=RequestMethod.POST)
    public String processRemoveCheese(@RequestParam ArrayList<String> cheesesToDelete) {
        for(String aCheese : cheesesToDelete) {
            for(Cheese cheese : cheeses) {
                if(cheese.getCheeseName().equals(aCheese)) {
                    cheeses.remove(cheese);
                    break;
                }
            }
        }

        return "redirect:";
    }

}