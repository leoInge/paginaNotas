package com.example.proyectoprograweb.logic;

public class Course {

    private String id;
    private String name;
    private String rate;

    public Course(String id, String name, String rate) {
        this.id = id;
        this.name = name;
        this.rate = rate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }
}
