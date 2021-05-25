package com.whatsnextfood.whatsnexthomescreen;

public class ProductModel {

    private int id;
    private String productNaam;
    private int aantal;
    private boolean isActive;

    //constructors

    public ProductModel(int id, String productNaam, int aantal, boolean isActive) {
        this.id = id;
        this.productNaam = productNaam;
        this.aantal = aantal;
        this.isActive = isActive;
    }

    public ProductModel() {
    }

    //toString is necessary for printing the contents of a class object

    @Override
    public String toString() {
        return "connectie{" +
                "id=" + id +
                ", naam='" + productNaam + '\'' +
                ", aantal=" + aantal +
                ", isActive=" + isActive +
                '}';
    }


    // getters ans setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaam() { return productNaam; }

    public void setNaam(String productNaam) {
        this.productNaam = productNaam;
    }

    public int getAantal() {
        return aantal;
    }

    public void setAantal(int age) {
        this.aantal = aantal;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}

