package com.example.dhealth_block;

import java.math.BigInteger;

public class PatientDispClass {

    private BigInteger id,adhar;
    private String name,acntadress;

    public PatientDispClass(BigInteger id, BigInteger adhar, String name, String acntadress) {
        this.id = id;
        this.adhar = adhar;
        this.name = name;
        this.acntadress = acntadress;
    }

    public BigInteger getId() {
        return id;
    }

    public BigInteger getAdhar() {
        return adhar;
    }

    public String getName() {
        return name;
    }

    public String getAcntadress() {
        return acntadress;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public void setAdhar(BigInteger adhar) {
        this.adhar = adhar;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAcntadress(String acntadress) {
        this.acntadress = acntadress;
    }
}
