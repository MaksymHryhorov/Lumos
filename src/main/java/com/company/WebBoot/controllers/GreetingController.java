package com.company.WebBoot.controllers;

import com.company.WebBoot.model.Features;
import com.company.WebBoot.service.FeatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

    @Autowired
    private FeatureService featureService;

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="Human") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    @GetMapping("/")
    public String featuresPage(Model model) {
        Iterable<Features> features = featureService.getAll();

        model.addAttribute("features", features);

        return "index";
    }
}
