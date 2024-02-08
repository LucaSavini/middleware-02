package com.example.Middleware02.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicController {

    @GetMapping("/")
    public String welcome() {
        return "Benvenuto nella nostra applicazione Spring Boot!";
    }

}
