package com.example.dhealth_block;

import java.math.BigInteger;

public class Disease {
    private String docname,disease;
    private BigInteger patientid,license,date;
    public Disease(BigInteger patientid, String docname, BigInteger license, BigInteger date, String disease) {
        this.patientid = patientid;
        this.docname = docname;
        this.license = license;
        this.date = date;
        this.disease = disease;
    }

    public String getDocname() {
        return docname;
    }

    public void setDocname(String docname) {
        this.docname = docname;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public BigInteger getPatientid() {
        return patientid;
    }

    public void setPatientid(BigInteger patientid) {
        this.patientid = patientid;
    }

    public BigInteger getLicense() {
        return license;
    }

    public void setLicense(BigInteger license) {
        this.license = license;
    }

    public BigInteger getDate() {
        return date;
    }

    public void setDate(BigInteger date) {
        this.date = date;
    }
}
