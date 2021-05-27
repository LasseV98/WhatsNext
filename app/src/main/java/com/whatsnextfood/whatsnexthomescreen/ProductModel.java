package com.whatsnextfood.whatsnexthomescreen;

public class ProductModel {
    private int id;
    private String name;
    private int number;
    private boolean isActive;

    //construtor
    public ProductModel(int id, String name,int number,boolean isActive)   {
        this.id = id;
        this.name = name;
        this.number = number;
        this.isActive = isActive;
    }
    public ProductModel() {

    }

    // to string


    @Override
    public String toString() {
        return "ProductModel{" +
                "id=" + id +
                ", name='" + name +
                ", number=" + number +
                ", isActive=" + isActive +
                '}';
    }

    // getters and setters
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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setSealed(boolean sealed) {
        isActive = sealed;
    }
}

