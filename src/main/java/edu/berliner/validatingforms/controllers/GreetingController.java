package edu.berliner.validatingforms.controllers;


import edu.berliner.validatingforms.Greeting;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class GreetingController {

    @GetMapping("/greeting")
    public String greetingForm(Model model)
    {
        model.addAttribute("greeting", new Greeting());
        return "greeting";
    }

    @PostMapping("/greeting")
    public String greetingSubmit(@Valid Greeting greeting, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
        {
            return "greeting";
        }
        return "result";
    }
}
