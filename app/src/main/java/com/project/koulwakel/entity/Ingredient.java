package com.project.koulwakel.entity;


public class Ingredient {

    private long id ;

    private String name ;

    private String unit_of_measure ;

    private Picture picture ;

    private Category category ;

    public Ingredient(long id, String name, String unit_of_measure, Picture picture, Category category) {
        this.id = id;
        this.name = name;
        this.unit_of_measure = unit_of_measure;
        this.picture = picture;
        this.category = category;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit_of_measure() {
        return unit_of_measure;
    }

    public void setUnit_of_measure(String unit_of_measure) {
        this.unit_of_measure = unit_of_measure;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
