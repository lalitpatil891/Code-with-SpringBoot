package com.lp.simpleWebApp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/log")@RequestMapping("/log")     //URL: http://localhost:8080/log/login
public class LoginController {

    @RequestMapping("/login")
    public String login() {
        return "This is the Login page..";
    }
}
