package com.example.myuserapplication.Application;

import android.os.Parcel;
import android.os.Parcelable;

public class Product implements Parcelable {
    private int mProduct_image;
    private String mProduct_Name;
    private long mProduct_Price;
    private int mProduct_count;

    public Product() {

    }

    public Product(int mProduct_image, String mProduct_Name, long mProduct_Price) {
        this.mProduct_image = mProduct_image;
        this.mProduct_Name = mProduct_Name;
        this.mProduct_Price = mProduct_Price;
        this.mProduct_count=0;
    }

    public long getmProduct_count() {
        return mProduct_count;
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

    // Parcelling part
    public Product(Parcel in){
        String[] data = new String[3];

        in.readStringArray(data);
        // the order needs to be the same as in writeToParcel() method
        this.mProduct_image = Integer.parseInt(data[0]);
        this.mProduct_Name = data[1];
        this.mProduct_Price = Integer.parseInt(data[2]);
    }

    @Override
    public int describeContents(){
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringArray(new String[] {String.valueOf(this.mProduct_image),
                this.mProduct_Name,
                String.valueOf(this.mProduct_Price)});
    }
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        public Product[] newArray(int size) {
            return new Product[size];
        }
    };
}
