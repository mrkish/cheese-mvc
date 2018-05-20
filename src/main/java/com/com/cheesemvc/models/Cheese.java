package com.com.cheesemvc.models;

public class Cheese {

    private String name;
    private String description;

    public Cheese(String name, String description) {
        this.name = name;
        this.description = description;
    }

    // Setters

    public void setCheeseName(String name) {
        this.name = name;
    }

    public void setCheeseDescription(String description) {
        this.description = description;
    }

    // Getters

    public String getCheeseName() {
        return this.name;
    }

    public String getCheeseDescription() {
        return this.description;
    }


}
