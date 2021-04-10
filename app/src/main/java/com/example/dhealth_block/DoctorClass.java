package com.example.dhealth_block;

public class DoctorClass {

    private String fullname, aadhar, sex, licno;

    public DoctorClass(String fullname, String aadhar, String sex, String licno) {
        this.fullname = fullname;
        this.aadhar = aadhar;
        this.sex = sex;
        this.licno = licno;
    }

    public String getFullname() {
        return fullname;
    }

    public String getAadhar() {
        return aadhar;
    }

    public String getSex() {
        return sex;
    }

    public String getLicno() {
        return licno;
    }
}
