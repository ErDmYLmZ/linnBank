package com.linnbank.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Country9 {
    private int id;
    private String name;
    private String states;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return states;
    }

    public void setState(String state) {
        this.states = state;
    }

    @Override
    public String toString() {
        return "Country9{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", state='" + states + '\'' +
                '}';
    }
}
