package com.example.myapplication;

import android.icu.lang.UProperty;

public class Incidence {
    protected String name;
    protected String urgency;
    protected String date;
    protected String state;

    Incidence(){
        name="Default Name";
        urgency="Default Urgence";
        date = "";
        state = "resolved";

    }

    public Incidence(String name, String urgency, String date){
        this.name=name;
        this.urgency=urgency;
        this.date = date;
    }

    public String getName(){
        return this.name;
    }
    public String getUrgency() {return this.urgency;}
    public String getDate(){return this.date;}
    public void setName(String name){this.name=name;}
    public void setUrgency(String urgency){this.urgency=urgency;}
}
