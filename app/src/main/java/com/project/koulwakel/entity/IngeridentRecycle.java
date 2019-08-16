package com.project.koulwakel.entity;

public class IngeridentRecycle {

    private  String titleIngredient ;
    private  int imgIngredient ;


    public IngeridentRecycle(String titleIngredient, int imgIngredient) {
        this.titleIngredient = titleIngredient;
        this.imgIngredient = imgIngredient;

    }

    public String getTitleIngredient() {
        return titleIngredient;
    }

    public void setTitleIngredient(String titleIngredient) {
        this.titleIngredient = titleIngredient;
    }

    public int getImgIngredient() {
        return imgIngredient;
    }

    public void setImgIngredient(int imgIngredient) {
        this.imgIngredient = imgIngredient;
    }


}
