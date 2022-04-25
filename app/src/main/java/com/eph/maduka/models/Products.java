package com.eph.maduka.models;

public class Products {
    private int image;
    private String names; //The total amount of a product
//    private Integer sold; //The total sold item
//    private  Integer remaining; //total - sold

    public Products(int image, String names) {
        this.image = image;
        this.names = names;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }
}



















