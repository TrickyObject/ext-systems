package mts.city.domain;

import java.time.LocalDate;

public class PersonRequest {

    private String surName;
    private String givenName;
    private String patronymicName;
    private LocalDate dateOfBirth;
    private Integer streetCode;
    private String building;
    private String extention;
    private String apartment;

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getPatronymicName() {
        return patronymicName;
    }

    public void setPatronymicName(String patronymicName) {
        this.patronymicName = patronymicName;
    }

    public Integer getStreetCode() {
        return streetCode;
    }

    public void setStreetCode(Integer streetCode) {
        this.streetCode = streetCode;
    }
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getExtention() {
        return extention;
    }

    public void setExtention(String extention) {
        this.extention = extention;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }
}