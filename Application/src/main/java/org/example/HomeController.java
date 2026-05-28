package org.example;

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
}