package com.example.myuserapplication.Application;

public class Item {

    private String name;
    private String subTitle;
    private int image;
    private String date;
    private String info;

    public Item() {

    }

    public Item(String name, String subTitle, int image, String date, String info) {
        this.name = name;
        this.subTitle = subTitle;
        this.image = image;
        this.date = date;
        this.info = info;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
