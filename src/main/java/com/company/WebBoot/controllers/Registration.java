package com.company.WebBoot.controllers;

import com.company.WebBoot.model.Users;
import com.company.WebBoot.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@Controller
public class Registration {

    @Autowired
    private UsersRepository usersRepository;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addRegUser(Users user, Map<String, Object> model) {
        Users userFromDB = usersRepository.findByFirstName(user.getFirstName());

        if (userFromDB != null) {
            model.put("message", "User exists!");
            return "/registration";
        }

        usersRepository.save(user);

        return "redirect:/login";
    }

}
