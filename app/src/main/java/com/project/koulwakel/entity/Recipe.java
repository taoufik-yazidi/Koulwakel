package com.project.koulwakel.entity;

import java.time.LocalTime;

public class Recipe {

    private long id ;

    private String title ;

    private LocalTime prepDuration ;

    private int nbPerson ;

    private String difficulty ;

    private String country ;

    private Family family ;


    private User user ;

    public Recipe(String title, String difficulty) {
        this.title = title;
        this.difficulty = difficulty;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalTime getPrepDuration() {
        return prepDuration;
    }

    public void setPrepDuration(LocalTime prepDuration) {
        this.prepDuration = prepDuration;
    }

    public int getNbPerson() {
        return nbPerson;
    }

    public void setNbPerson(int nbPerson) {
        this.nbPerson = nbPerson;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
