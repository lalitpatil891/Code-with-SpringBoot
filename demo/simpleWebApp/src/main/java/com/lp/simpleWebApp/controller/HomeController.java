package com.lp.simpleWebApp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @RequestMapping("/")
//    @ResponseBody
    public String greet() {
        return "Welcome to the world!!! I am lalit.";
    }

    @RequestMapping("/about")
    public String about(){
        return "This is the about page..";
    }


}
