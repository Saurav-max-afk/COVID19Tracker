package com.aptron.covid19tracker;

import org.json.JSONArray;

public class States {

    public JSONArray getJSONArray;
    private String name;
    private String confirmed;
    private String cured;
    private String death;
    private String active;

    public States() {}

    public States(String name,String confirmed,String cured,String death,String active)
    {
        this.name=name;
        this.confirmed=confirmed;
        this.cured=cured;
        this.death=death;
        this.active=active;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(String confirmed) {
        this.confirmed = confirmed;
    }

    public String getCured() {
        return cured;
    }

    public void setCured(String cured) {
        this.cured = cured;
    }

    public String getDeath() {
        return death;
    }

    public void setDeath(String death) {
        this.death = death;
    }
    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }


}

