package com.example.mushroomapp.models;

public class HTDData {

    String imgDetails;
    String hTime;
    String hDate;
    String hStatus;

    public HTDData(String imgDetails, String hTime, String hDate, String hStatus) {
        this.imgDetails = imgDetails;
        this.hTime = hTime;
        this.hDate = hDate;
        this.hStatus = hStatus;
    }

    public String getImgDetails() {
        return imgDetails;
    }

    public String gethTime() {
        return hTime;
    }

    public String gethDate() {
        return hDate;
    }

    public String gethStatus() {
        return hStatus;
    }
}
