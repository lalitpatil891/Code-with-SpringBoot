package com.lp;

public class Laptop {

    private String name;

    public Laptop() {
        System.out.println("Laptop Constructor...");
    }

    public Laptop(String name) {
        this.name= name;
        System.out.println("Parameterize Constructor..");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void compile() {
        System.out.println("Compiling...");
    }
}
