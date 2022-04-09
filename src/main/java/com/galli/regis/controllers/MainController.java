package com.galli.regis.controllers;

import com.galli.regis.models.Email;
import com.galli.regis.repository.ListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @Autowired
    private ListRepository listRepository;

    @GetMapping("/")
    public String home(Model model){
        Iterable<Email> emails=listRepository.findAll();
        model.addAttribute("posts", emails);
        return "home";
    }

    @GetMapping("/regis")
    public String regis(Model model){
        return "regis";
    }

    @PostMapping("/regis")
    public String DataAdd(@RequestParam String name, @RequestParam String email, Model model){
        Email post = new Email(name, email);
        listRepository.save(post);
        return "redirect:/";
    }

}