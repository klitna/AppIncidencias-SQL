package com.example.myapplication;

public class Incidence {
    protected String name;
    protected String urgence;

    Incidence(){
        name="Default Name";
        urgence="Default Urgence";
    }

    public Incidence(String name, String urgence){
        this.name=name;
        this.urgence=urgence;
    }

    public String getName(){
        return this.name;
    }
    public String getUrgence() {return this.urgence;}
}
