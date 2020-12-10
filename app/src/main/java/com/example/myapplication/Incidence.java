package com.example.myapplication;

public class Incidence {
    protected String name;
    protected String urgency;

    Incidence(){
        name="Default Name";
        urgency="Default Urgence";

    }

    public Incidence(String name, String urgency){
        this.name=name;
        this.urgency=urgency;
    }

    public String getName(){
        return this.name;
    }
    public String getUrgency() {return this.urgency;}
    public void setName(String name){this.name=name;}
    public void setUrgency(String urgency){this.urgency=urgency;}
}
