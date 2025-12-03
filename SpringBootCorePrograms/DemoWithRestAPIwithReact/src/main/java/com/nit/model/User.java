package com.nit.model;

public class User {
	private String name;
    private int age;

    // constructor
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // getters (required for JSON)
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
	
}
