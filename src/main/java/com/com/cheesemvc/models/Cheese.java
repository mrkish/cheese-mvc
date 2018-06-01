package com.com.cheesemvc.models;

public class Cheese {

    private String name;
    private String description;



    private int cheeseId;
    private static int nextId = 1;

    public Cheese(String name, String description) {
        this();
        this.name = name;
        this.description = description;
    }

    public Cheese() {
        cheeseId = nextId;
        nextId++;
    }

    public void setCheeseId(int cheeseId) { this.cheeseId = cheeseId; }

    public void setCheeseName(String name) {
        this.name = name;
    }

    public void setCheeseDescription(String description) {
        this.description = description;
    }

    public int getCheeseId() { return cheeseId; }

    public String getCheeseName() {
        return this.name;
    }

    public String getCheeseDescription() {
        return this.description;
    }

}
