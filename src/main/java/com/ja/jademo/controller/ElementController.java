package com.ja.jademo.controller;

import com.ja.jademo.model.Element;
import com.ja.jademo.repository.ElementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/education")
public class ElementController {
    @Autowired
    private ElementRepository elementRepository;

    @GetMapping("/education")
    public String education(Model model){
        List<Element> elements = elementRepository.findAll();
        model.addAttribute("elements", elements);
        return "education/education";
    }

    @GetMapping("/form")
    public String form(Model model){
        model.addAttribute("element", new Element());
        return "education/form";
    }

    @PostMapping("/form")
    public String greetingSubmit(@ModelAttribute Element element){
        elementRepository.save(element);
        return "redirect:/education/education";
    }
}
