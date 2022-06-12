package com.company.WebBoot.controllers;

import com.company.WebBoot.model.Features;
import com.company.WebBoot.repository.FeaturesRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class FeaturesController {

    private final FeaturesRepository featuresRepository;

    public FeaturesController(FeaturesRepository featuresRepository) {
        this.featuresRepository = featuresRepository;
    }

    @GetMapping("/features")
    public String featuresPage(Model model) {
        Iterable<Features> features = featuresRepository.findAll();
        model.addAttribute("features", features);

        return "featuresHtml/features_page";
    }

    @GetMapping("/feature/add")
    public String featureAdd(Model model) {
        return "featuresHtml/feature_add";
    }

    @PostMapping("/feature/add")
    public String featureAdd(@RequestParam String title,
                             @RequestParam String name,
                             @RequestParam String text,
                             Model model) {


        Features features = new Features(title,name,text);
        featuresRepository.save(features);

        return "redirect:/features";
    }

    @GetMapping("/features/{id}")
    public String featuresDetail(@PathVariable(value = "id") int id,
                                 Model model) {
        if(!featuresRepository.existsById(id)) {
            return "redirect:/features";
        }

        Optional<Features> features = featuresRepository.findById(id);
        ArrayList<Features> arrayList = new ArrayList<>();

        features.ifPresent(arrayList::add);
        model.addAttribute("post", arrayList);

        return "featuresHtml/features_detail";
    }

    @GetMapping("/features/{id}/edit")
    public String editFeatures(@PathVariable(value = "id") int id,
                               Model model) {
        Optional<Features> features = featuresRepository.findById(id);
        ArrayList<Features> arrayList = new ArrayList<>();

        features.ifPresent(arrayList::add);
        model.addAttribute("post", arrayList);

        return "featuresHtml/features_edit";
    }

    @PostMapping("/features/{id}/edit")
    public String featureAddUpdate(@PathVariable(value = "id") int id,
                                   @RequestParam String title,
                             @RequestParam String name,
                             @RequestParam String text,
                             Model model) {

        Features features = featuresRepository.findById(id).orElseThrow();
        features.setTitle(title);
        features.setName(name);
        features.setText(text);

        featuresRepository.save(features);

        return "redirect:/features";
    }

    @PostMapping("/features/{id}/delete")
    public String featureDelete(@PathVariable(value = "id") int id,
                             Model model) {

        Features features = featuresRepository.findById(id).orElseThrow();
        featuresRepository.delete(features);

        return "redirect:/features";
    }
}
