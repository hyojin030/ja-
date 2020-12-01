package com.ja.jademo.controller;

import com.ja.jademo.model.Element;
import com.ja.jademo.model.Middle;
import com.ja.jademo.repository.MiddleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/education")
public class MiddleController {
    @Autowired
    private MiddleRepository middleRepository;

    @GetMapping("/middle")
    public String education(Model model, @RequestParam(required=false) Long id){
        List<Middle> middles = middleRepository.findAll();
        model.addAttribute("middles", middles);
        if (id == null) {
            model.addAttribute("middle", new Middle());
        } else {
            Middle middle = middleRepository.findById(id).orElse(null);
            model.addAttribute("middle", middle);
        }
        return "education/middle";
    }

    @PostMapping("/middle")
    public String greetingSubmit(@ModelAttribute Middle middle){
        middleRepository.save(middle);
        return "redirect:/education/middle";
    }

/*    @GetMapping("/form")
    public String form(Model model, @RequestParam(required=false) Long id){
        if (id == null) {
            model.addAttribute("element", new Element());
        } else {
            Element element = elementRepository.findById(id).orElse(null);
            model.addAttribute("element", element);
        }
        return "education/form";
    }

    @PostMapping("/form")
    public String greetingSubmit(@ModelAttribute Element element){
        elementRepository.save(element);
        return "redirect:/education/education";
    }*/
}
