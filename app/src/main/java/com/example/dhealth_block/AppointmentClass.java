package com.example.dhealth_block;

public class AppointmentClass {

    private String date, symptoms;

    public AppointmentClass(String date, String symptoms) {
        this.date = date;
        this.symptoms = symptoms;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }
}
