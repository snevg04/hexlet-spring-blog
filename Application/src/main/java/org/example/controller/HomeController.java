package org.example.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "Добро пожаловать в Hexlet Spring Blog! Herzlich willkommen!";
    }

    @GetMapping("/about")
    public String about() {
        return "This is simple Spring blog!";
    }

    @Value("${app.welcome-message}")
    private String welcomeMessage;

    @GetMapping("/welcome")
    public String welcome() {
        return welcomeMessage;
    }

    @Value("${app.admin-email}")
    private String adminEmail;

    @GetMapping("/admin")
    public String contactAdmin() {
        return adminEmail;
    }

    @Value("${app.page-size}")
    private String pageSize;

    @GetMapping("/size")
    public String answer() {
        return pageSize;
    }
}