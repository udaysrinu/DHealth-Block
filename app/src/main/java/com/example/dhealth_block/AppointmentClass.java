package com.example.dhealth_block;

public class AppointmentClass {

    private String date, month, year, symptoms, medicines, progress, note;

    public AppointmentClass(String date, String month, String year, String symptoms, String medicines, String progress, String note) {
        this.date = date;
        this.month = month;
        this.year = year;
        this.symptoms = symptoms;
        this.medicines = medicines;
        this.progress = progress;
        this.note = note;
    }

    public String getDate() {
        return date;
    }

    public String getMonth() {
        return month;
    }

    public String getYear() {
        return year;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public String getMedicines() {
        return medicines;
    }

    public String getProgress() {
        return progress;
    }

    public String getNote() {
        return note;
    }
}
