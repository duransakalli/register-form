package com.form.controller;

import com.form.model.User;
import com.form.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String showForm(Model model){
        User user = new User();
        model.addAttribute("user", user);

        List<String> professionList = Arrays.asList("Actor", "Acupuncturist", "Fashion Designer",
                "FBI Agent", "Financial Analyst","Firefighter", "Fisher", "Forester",
                "Geographer", "Imam", "Lawyer and Judge","Locksmith","Mathematician",
                "Optometrist","Pharmacist","Pilot","Other");
        model.addAttribute("professionList",professionList);

        return "register_form";
    }

    @PostMapping("/register")
    public String submitForm(@ModelAttribute("user") User user){
        userService.save(user);
        System.out.println(user);
        return "register_success";
    }
}
