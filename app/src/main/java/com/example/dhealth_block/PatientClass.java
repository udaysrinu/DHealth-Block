package com.example.dhealth_block;

public class PatientClass {

//    private String full_name, sex,date,month,year;

//    public PatientClass(String full_name, String sex, String date, String month, String year) {
//        this.full_name = full_name;
//        this.sex = sex;
//        this.date = date;
//        this.month = month;
//        this.year = year;
//    }

//    public String getFull_name() {
//        return full_name;
//    }
//
//    public String getSex() {
//        return sex;
//    }
//
//    public String getDate() {
//        return date;
//    }
//
//    public String getMonth() {
//        return month;
//    }
//
//    public String getYear() {
//        return year;
//    }

    private String fullName, adhar,privatekey, accountaddress;

    public PatientClass(String fullName, String adhar, String id, String accountaddress) {
        this.fullName = fullName;
        this.adhar = adhar;
        this.privatekey = id;
        this.accountaddress = accountaddress;
    }

    public String getFullName() {
        return fullName;
    }

    public String getAdhar() {
        return adhar;
    }

    public String getid() {
        return privatekey;
    }

    public String getAccountaddress() {
        return accountaddress;
    }
}
