package com.example.webpgtest.controller;

import com.example.webpgtest.domain.User;
import com.example.webpgtest.dto.UserDto;
import com.example.webpgtest.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @PostMapping("/{id}/update")
    public String update(@PathVariable("id") Long id, @ModelAttribute UserDto userDto) {
        Optional<UserDto> optionalUserDto = userService.update(id, userDto);
        if(optionalUserDto.isEmpty()) {
            System.out.println("optionalUserDto.isEmpty() !!!!!");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return "redirect:/users/" + optionalUserDto.get().getId();
    }

    @GetMapping("/registration")
    public String registration(Model model, UserDto userDto) {
        model.addAttribute("user", userDto);
//        System.out.println("!!!!! @GetMapping(registration)");
        return "user/registration";
    }

    @PostMapping
    public String registration(@ModelAttribute("user") UserDto userDto, RedirectAttributes redirectAttributes) {
        System.out.println("!!!!! @PostMapping(registration)");
        return "redirect:/users/" + userService.create(userDto).getId();
    }

    @PostMapping("{id}/delete")
    public String delete(@PathVariable("id") Long id) {
        userService.deleteById(id);
        return "redirect:/users";
    }

}
