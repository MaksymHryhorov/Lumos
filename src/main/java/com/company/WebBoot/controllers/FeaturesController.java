package com.company.WebBoot.controllers;

import com.company.WebBoot.model.Features;
import com.company.WebBoot.model.Users;
import com.company.WebBoot.repository.FeaturesRepository;
import com.company.WebBoot.repository.UsersRepository;
import com.company.WebBoot.service.FeatureService;
import com.company.WebBoot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class FeaturesController {

    private final FeaturesRepository featuresRepository;

    @Autowired
    private FeatureService featureService;


    public FeaturesController(FeaturesRepository featuresRepository) {
        this.featuresRepository = featuresRepository;
    }

    @GetMapping("/features")
    public String featuresPage(Model model) {
        Iterable<Features> features = featureService.getAll();

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
                             @RequestParam double cost,
                             Model model) {

        Users users = new Users();
        users.setUser_id(43);

        Features features = new Features(title, name, text, users, cost);
        featureService.save(features);

        return "redirect:/features";
    }

    @GetMapping("/features/{id}")
    public String featuresDetail(@PathVariable(value = "id") int id,
                                 Model model) {

        if (!featuresRepository.existsById(id)) {
            return "redirect:/features";
        }

        ArrayList<Features> arrayList = featureService.detail(id);
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
                                   @RequestParam double cost,
                                   Model model) {

        Features features = featuresRepository.findById(id).orElseThrow();
        features.setTitle(title);
        features.setName(name);
        features.setText(text);
        features.setCost(cost);

        featuresRepository.save(features);

        return "redirect:/features";
    }

    @PostMapping("/features/{id}/delete")
    public String featureDelete(@PathVariable(value = "id") int id,
                                Model model) {

        Features features = featureService.getById(id);

        if (features == null) {
            return "redirect:/features";
        }

        featureService.delete(id);

        return "redirect:/features";
    }

}
