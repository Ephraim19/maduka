package com.eph.maduka.models;

public class Products {
    private int image;
    private String names;
    private String price; //The price of an item
    private String quantity;
//    private  Integer remaining; //total - sold

    public Products(int image, String names, String price,String quantity) {
        this.image = image;
        this.names = names;
        this.price = price;
        this.quantity = quantity;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(){
        this.price = price;
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

































