package com.example.webpgtest.controller;

import com.example.webpgtest.domain.User;
import com.example.webpgtest.dto.UserReadDto;
import com.example.webpgtest.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//localhost:8080/users
@Controller
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    @GetMapping
    public String findAll(Model model) {

        model.addAttribute("users", userService.findAll());
        return "user/users";
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable("id") Long id, Model model) {
        Optional<User> optionalUser = userService.findById(id);
        if(optionalUser.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        model.addAttribute("user", optionalUser.get());
        return "user/user";

//        return "users";
    }

//    @PostMapping("/{id}/update")
//    public String update(@PathVariable("id") Long id, @ModelAttribute User user) {
//        Optional<User> optionalUser = userService.findById(id);
//        if(optionalUser.isEmpty()) {
//            throw new IllegalArgumentException();
//        }
//        User userOriginal = optionalUser.get();
//
//
////        return userService.update(id, user)
////                .map(it -> "redirect:/users/{id}")
////                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
//    }

    @PostMapping("/{id}/update")
    public String update(@PathVariable("id") Long id, @ModelAttribute User user) {
        Optional<User> optionalUser = userService.update(id, user);
        if(optionalUser.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return "redirect:/users/" + optionalUser.get().getId();
    }

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("user", new User());
//        System.out.println("!!!!! @GetMapping(registration)");
        return "user/registration";
    }

    @PostMapping
    public String registration(@ModelAttribute("user") User user,  RedirectAttributes redirectAttributes) {
        System.out.println("!!!!! @PostMapping(registration)");
        User saved = userService.create(user);
        return "redirect:/users/" + saved.getId();
    }

    @PostMapping("{id}/delete")
    public String delete(@PathVariable("id") Long id) {
        userService.deleteById(id);
        return "redirect:/users";
    }

    @GetMapping("/test")
    public String test(Model model) {
        int i = 1;
        model.addAttribute("users", new User(1L, "First", "mymail"));
        return "test";
    }




}
