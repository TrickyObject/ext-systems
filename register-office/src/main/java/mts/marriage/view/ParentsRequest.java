package mts.marriage.view;

import java.io.Serializable;
import java.time.LocalDate;

public class ParentsRequest implements Serializable {

    private String fatherSurName;
    private String fatherGivenName;
    private String fatherPatronymic;
    private LocalDate fatherBirthDay;
    private String fatherPassportSerial;
    private String fatherPassportNumber;
    private LocalDate fatherPassportDate;

    private String motherSurName;
    private String motherGivenName;
    private String motherPatronymic;
    private LocalDate motherBirthDay;
    private String motherPassportSerial;
    private String motherPassportNumber;
    private LocalDate motherPassportDate;

    private String parentCertNumber;
    private LocalDate parentCertDate;


    @Override
    public String toString() {
        return "ParentsRequest{" +
                "fatherSurName='" + fatherSurName + '\'' +
                ", fatherGivenName='" + fatherGivenName + '\'' +
                ", fatherPatronymic='" + fatherPatronymic + '\'' +
                ", fatherBirthDay=" + fatherBirthDay +
                ", fatherPassportSerial='" + fatherPassportSerial + '\'' +
                ", fatherPassportNumber='" + fatherPassportNumber + '\'' +
                ", fatherPassportDate=" + fatherPassportDate +
                ", motherSurName='" + motherSurName + '\'' +
                ", motherGivenName='" + motherGivenName + '\'' +
                ", motherPatronymic='" + motherPatronymic + '\'' +
                ", motherBirthDay=" + motherBirthDay +
                ", motherPassportSerial='" + motherPassportSerial + '\'' +
                ", motherPassportNumber='" + motherPassportNumber + '\'' +
                ", motherPassportDate=" + motherPassportDate +
                ", parentCertNumber='" + parentCertNumber + '\'' +
                ", parentCertDate=" + parentCertDate +
                '}';
    }

    public String getFatherSurName() {
        return fatherSurName;
    }

    public void setFatherSurName(String fatherSurName) {
        this.fatherSurName = fatherSurName;
    }

    public String getFatherGivenName() {
        return fatherGivenName;
    }

    public void setFatherGivenName(String fatherGivenName) {
        this.fatherGivenName = fatherGivenName;
    }

    public String getFatherPatronymic() {
        return fatherPatronymic;
    }

    public void setFatherPatronymic(String fatherPatronymic) {
        this.fatherPatronymic = fatherPatronymic;
    }

    public LocalDate getFatherBirthDay() {
        return fatherBirthDay;
    }

    public void setFatherBirthDay(LocalDate fatherBirthDay) {
        this.fatherBirthDay = fatherBirthDay;
    }

    public String getFatherPassportSerial() {
        return fatherPassportSerial;
    }

    public void setFatherPassportSerial(String fatherPassportSerial) {
        this.fatherPassportSerial = fatherPassportSerial;
    }

    public String getFatherPassportNumber() {
        return fatherPassportNumber;
    }

    public void setFatherPassportNumber(String fatherPassportNumber) {
        this.fatherPassportNumber = fatherPassportNumber;
    }

    public LocalDate getFatherPassportDate() {
        return fatherPassportDate;
    }

    public void setFatherPassportDate(LocalDate fatherPassportDate) {
        this.fatherPassportDate = fatherPassportDate;
    }

    public String getMotherSurName() {
        return motherSurName;
    }

    public void setMotherSurName(String motherSurName) {
        this.motherSurName = motherSurName;
    }

    public String getMotherGivenName() {
        return motherGivenName;
    }

    public void setMotherGivenName(String motherGivenName) {
        this.motherGivenName = motherGivenName;
    }

    public String getMotherPatronymic() {
        return motherPatronymic;
    }

    public void setMotherPatronymic(String motherPatronymic) {
        this.motherPatronymic = motherPatronymic;
    }

    public LocalDate getMotherBirthDay() {
        return motherBirthDay;
    }

    public void setMotherBirthDay(LocalDate motherBirthDay) {
        this.motherBirthDay = motherBirthDay;
    }

    public String getMotherPassportSerial() {
        return motherPassportSerial;
    }

    public void setMotherPassportSerial(String motherPassportSerial) {
        this.motherPassportSerial = motherPassportSerial;
    }

    public String getMotherPassportNumber() {
        return motherPassportNumber;
    }

    public void setMotherPassportNumber(String motherPassportNumber) {
        this.motherPassportNumber = motherPassportNumber;
    }

    public LocalDate getMotherPassportDate() {
        return motherPassportDate;
    }

    public void setMotherPassportDate(LocalDate motherPassportDate) {
        this.motherPassportDate = motherPassportDate;
    }

    public String getParentCertNumber() {
        return parentCertNumber;
    }

    public void setParentCertNumber(String parentCertNumber) {
        this.parentCertNumber = parentCertNumber;
    }

    public LocalDate getParentCertDate() {
        return parentCertDate;
    }

    public void setParentCertDate(LocalDate parentCertDate) {
        this.parentCertDate = parentCertDate;
    }
}
