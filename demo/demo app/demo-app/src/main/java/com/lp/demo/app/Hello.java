package com.lp.demo.app;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {

    @RequestMapping
    public String greet() {

        return "Hello world, I am Lalit Patil";
    }

}
