package org.timowa.spring.http.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.timowa.spring.dto.UserCreatedEditDto;
import org.timowa.spring.service.UserService;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public String findAll(Model model) {
        return "user/users";
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable("id") Long id, Model model) {
        return "user/user";
    }

    @PostMapping
    public String create(@ModelAttribute UserCreatedEditDto user) {
        return "redirect:/users/" + 25;
    }

    @PostMapping("/{id}/update")
    public String update(@PathVariable("id") Long id, @ModelAttribute UserCreatedEditDto user) {
        return "redirect:/users/{id}";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable("id") Long id) {
        return "users";
    }
}
