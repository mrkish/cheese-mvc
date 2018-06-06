package com.com.cheesemvc.controllers;

import com.com.cheesemvc.models.Cheese;
import com.com.cheesemvc.models.CheeseData;
import com.com.cheesemvc.models.CheeseType;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("cheese")
public class CheeseController {

    @RequestMapping(value = "")
    public String index(Model model) {
        model.addAttribute("cheeses", CheeseData.getAll());
        model.addAttribute("title", "My cheeses");

        return "cheese/index";
    }

    @RequestMapping(value="add", method = RequestMethod.GET)
    public String displayAddCheeseForm(Model model) {
        model.addAttribute("title","Add cheese");
        model.addAttribute(new Cheese());
        model.addAttribute("cheeseTypes", CheeseType.values());

        return "cheese/add";
    }

    @RequestMapping(value="add", method = RequestMethod.POST)
    public String processAddCheeseForm(Model model, @ModelAttribute @Valid Cheese newCheese,
                                       Errors errors) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add cheese");
            return "cheese/add";
        }

        CheeseData.add(newCheese);

        return "redirect:";
    }

    @RequestMapping(value="remove", method=RequestMethod.GET)
    public String removeCheeseForm(Model model) {
        model.addAttribute("title", "Remove cheese");
        model.addAttribute("cheeses", CheeseData.getAll());

        return "cheese/remove";
    }

    @RequestMapping(value="remove", method=RequestMethod.POST)
    public String processRemoveCheese(@RequestParam int[] cheeseIds) {
        for (int cheeseId : cheeseIds) {
            CheeseData.remove(cheeseId);
        }

        return "redirect:";
    }


    @RequestMapping(value="edit/{cheeseId}", method=RequestMethod.GET)
    public String displayEditForm(Model model, @PathVariable int cheeseId) {

        Cheese getThisCheese = CheeseData.getById(cheeseId);
        model.addAttribute("cheese", getThisCheese);
        model.addAttribute("cheeseTypes", CheeseType.values());

        return "cheese/edit";
    }

    @RequestMapping(value="edit/{cheeseId}", method=RequestMethod.POST)
    public String processEditForm(@PathVariable int cheeseId, @Valid String name,
                                  @Valid String description, CheeseType cheeseType) {
        Cheese cheeseToEdit = CheeseData.getById(cheeseId);
        cheeseToEdit.setName(name);
        cheeseToEdit.setDescription((description));
        cheeseToEdit.setType(cheeseType);

        return "redirect:";
    }
}