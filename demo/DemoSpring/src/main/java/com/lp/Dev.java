package com.lp;


public class Dev {

    private Laptop laptop;

    private int age;

    public Dev() {
        System.out.println("Dev Constructor..");
    }

    public Dev(Laptop laptop) { //Constructor injection
        this.laptop = laptop;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Laptop getLaptop() {
        return laptop;
    }

    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    }

    public void build() {
        System.out.println("Name: "+laptop.getName());
        System.out.println("Age: "+getAge());
        laptop.compile();
        System.out.println("Working on Awesome Ptoject");
    }
}
