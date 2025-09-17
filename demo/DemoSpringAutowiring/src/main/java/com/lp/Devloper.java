package com.lp;


public class Devloper {

    private Computer comp;

    public Devloper() {
        System.out.println("Developer Constructor.");
    }

    //Setter Getter for Computer
    public Computer getComp() {
        return comp;
    }

    public void setComp(Computer comp) {
        this.comp = comp;
    }

    public void build() {
        System.out.println("Working with Awesome Project.");
        comp.compile();
    }
}
