package com.example.dhealth_block;

public class Disease {
    private String DiseaseName,DoctorTreated,date,precautions,Description,Medicines,Symptons;

    public Disease(String diseaseName, String doctorTreated, String date, String precautions, String description, String medicines, String symptons) {
        DiseaseName = diseaseName;
        DoctorTreated = doctorTreated;
        this.date = date;
        this.precautions = precautions;
        Description = description;
        Medicines = medicines;
        Symptons = symptons;
    }

    public String getDiseaseName() {
        return DiseaseName;
    }

    public void setDiseaseName(String diseaseName) {
        DiseaseName = diseaseName;
    }

    public String getDoctorTreated() {
        return DoctorTreated;
    }

    public void setDoctorTreated(String doctorTreated) {
        DoctorTreated = doctorTreated;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPrecautions() {
        return precautions;
    }

    public void setPrecautions(String precautions) {
        this.precautions = precautions;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getMedicines() {
        return Medicines;
    }

    public void setMedicines(String medicines) {
        Medicines = medicines;
    }

    public String getSymptons() {
        return Symptons;
    }

    public void setSymptons(String symptons) {
        Symptons = symptons;
    }
}
