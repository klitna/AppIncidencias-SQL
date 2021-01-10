package com.example.myapplication;

import android.icu.lang.UProperty;

public class Incidence {
    protected String name;
    protected String urgency;
    protected String date;

    //0=pending 1=assigned 2=resolved
    protected int state;

    Incidence(){
        name="Default Name";
        urgency="Default Urgence";
        date = "";
        state = 0;

    }

    public Incidence(String name, String urgency, String date, int state){
        this.name=name;
        this.urgency=urgency;
        this.date = date;
        this.state = state;
    }

    public String getName(){
        return this.name;
    }
    public String getUrgency() {return this.urgency;}
    public String getDate(){return this.date;}
    public int getState(){return this.state;}
    public void setName(String name){this.name=name;}
    public void setState(int state){this.state=state;}
    public void setUrgency(String urgency){this.urgency=urgency;}
}
