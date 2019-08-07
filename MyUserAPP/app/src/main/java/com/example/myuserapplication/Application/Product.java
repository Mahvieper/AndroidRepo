package com.example.myuserapplication.Application;

public class Product {
    private int mProduct_image;
    private String mProduct_Name;
    private long mProduct_Price;

    public Product() {

    }

    public Product(int mProduct_image, String mProduct_Name, long mProduct_Price) {
        this.mProduct_image = mProduct_image;
        this.mProduct_Name = mProduct_Name;
        this.mProduct_Price = mProduct_Price;
    }

    public int getmProduct_image() {
        return mProduct_image;
    }

    public void setmProduct_image(int mProduct_image) {
        this.mProduct_image = mProduct_image;
    }

    public String getmProduct_Name() {
        return mProduct_Name;
    }

    public void setmProduct_Name(String mProduct_Name) {
        this.mProduct_Name = mProduct_Name;
    }

    public long getmProduct_Price() {
        return mProduct_Price;
    }

    public void setmProduct_Price(int mProduct_Price) {
        this.mProduct_Price = mProduct_Price;
    }
}
