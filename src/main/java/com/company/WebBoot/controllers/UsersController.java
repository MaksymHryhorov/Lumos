package com.company.WebBoot.controllers;

import com.company.WebBoot.model.Features;
import com.company.WebBoot.model.Users;
import com.company.WebBoot.repository.UsersRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class UsersController {

    private final UsersRepository usersRepository;

    public UsersController(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @GetMapping("/users")
    public String showUsers(Model model) {
        Iterable<Users> users = usersRepository.findAll();
        model.addAttribute("users", users);

        return "userFilesHtml/user_list";
    }


    @GetMapping("/user/add")
    public String addUser(Model model) {
        return "userFilesHtml/users_add";
    }

    @PostMapping("/user/add")
    public String featureAdd(@RequestParam String firstName,
                             @RequestParam String secondName,
                             @RequestParam String email,
                             @RequestParam String password,
                             Model model) {


        Users users = new Users(firstName, secondName, email, password);
        usersRepository.save(users);

        return "redirect:/users";
    }

    @GetMapping("/users/{id}")
    public String userDetail(@PathVariable(value = "id") int id,
                             Model model) {
        if (!usersRepository.existsById(id))
            return "redirect:/user";

        Optional<Users> users = usersRepository.findById(id);
        ArrayList<Users> arrayList = new ArrayList<>();

        users.ifPresent(arrayList::add);
        model.addAttribute("user", arrayList);

        return "userFilesHtml/user_detail";
    }

    @GetMapping("/users/{id}/edit")
    public String editFeatures(@PathVariable(value = "id") int id,
                               Model model) {
        Optional<Users> users = usersRepository.findById(id);
        ArrayList<Users> arrayList = new ArrayList<>();

        users.ifPresent(arrayList::add);
        model.addAttribute("userEdit", arrayList);

        return "userFilesHtml/user_edit";
    }

    @PostMapping("/users/{id}/edit")
    public String featureAddUpdate(@PathVariable(value = "id") int id,
                                   @RequestParam String firstName,
                                   @RequestParam String secondName,
                                   Model model) {

        Users users = usersRepository.findById(id).orElseThrow();
        users.setFirstName(firstName);
        users.setSecondName(secondName);

        usersRepository.save(users);

        return "redirect:/users";
    }

    @PostMapping("/users/{id}/delete")
    public String featureDelete(@PathVariable(value = "id") int id,
                                Model model) {

        Users user = usersRepository.findById(id).orElseThrow();
        usersRepository.delete(user);

        return "redirect:/users";
    }
}
