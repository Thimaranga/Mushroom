package com.example.mushroomapp.models;

public class EMSData {
    String sendTemp;
    String sendHum;
    String sendCo2;
    String sendDate;
    String sendTime;

    public EMSData(String sendTemp, String sendHum, String sendCo2, String sendDate, String sendTime) {
        this.sendTemp = sendTemp;
        this.sendHum = sendHum;
        this.sendCo2 = sendCo2;
        this.sendDate = sendDate;
        this.sendTime = sendTime;
    }

    public String getSendTemp() {
        return sendTemp;
    }

    public String getSendHum() {
        return sendHum;
    }

    public String getSendCo2() {
        return sendCo2;
    }

    public String getSendDate() {
        return sendDate;
    }

    public String getSendTime() {
        return sendTime;
    }

}
