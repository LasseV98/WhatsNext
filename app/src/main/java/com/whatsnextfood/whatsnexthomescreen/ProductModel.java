package com.whatsnextfood.whatsnexthomescreen;

public class ProductModel {

    private int id;
    private String productName;
    private int number;
    private boolean isActive;

    //constructors

    public ProductModel(int id, String productName, int number, boolean isActive) {
        this.id = id;
        this.productName = productName;
        this.number = number;
        this.isActive = isActive;
    }

    public ProductModel() {
    }

    //toString is necessary for printing the contents of a class object

    @Override
    public String toString() {
        return "ProductModel{" +
                "id=" + id +
                ", name='" + productName + '\'' +
                ", number=" + number +
                ", isSealed=" + isActive +
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
        return productName;
    }

    public void setName(String name) {
        this.productName = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isSealed() {
        return isActive;
    }

    public void setSealed(boolean sealed) {
        isActive = sealed;
    }
}
