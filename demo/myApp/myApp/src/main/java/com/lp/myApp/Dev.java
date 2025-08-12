package com.lp.myApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.logging.logback.StructuredLogEncoder;
import org.springframework.stereotype.Component;

@Component
public class Dev {
    //@Qualifier("desktop")
    @Autowired() //Field injection
    private Computer comp;

    /* //@Autowired      //Constructor injection -> Default
    public Dev(Laptop laptop) {
        this.laptop = laptop;
        System.out.println("Contructor Injection...");
    }

    @Autowired      //Setter injection
    public void setLaptop(Laptop laptop) {
        this.laptop= laptop;
        System.out.println("Setter Method is called.");
    }
    */

    public void build() {
        comp.compile();
        System.out.println("Working on Awesome Ptoject");
    }

}
