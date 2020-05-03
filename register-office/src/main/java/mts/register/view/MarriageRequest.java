package mts.register.view;

import java.io.Serializable;
import java.time.LocalDate;

public class MarriageRequest implements Serializable {

    private String husbandSurName;
    private String husbandGivenName;
    private String husbandPatronymic;
    private LocalDate husbandBirthDay;
    private String husbandPassportSerial;
    private String husbandPassportNumber;
    private LocalDate husbandPassportDate;

    private String wifeSurName;
    private String wifeGivenName;
    private String wifePatronymic;
    private LocalDate wifeBirthDay;
    private String wifePassportSerial;
    private String wifePassportNumber;
    private LocalDate wifePassportDate;

    private String marriageCertNumber;
    private LocalDate marriageCertDate;


    public String getHusbandSurName() {
        return husbandSurName;
    }

    public void setHusbandSurName(String husbandSurName) {
        this.husbandSurName = husbandSurName;
    }

    public String getHusbandGivenName() {
        return husbandGivenName;
    }

    public void setHusbandGivenName(String husbandGivenName) {
        this.husbandGivenName = husbandGivenName;
    }

    public String getHusbandPatronymic() {
        return husbandPatronymic;
    }

    public void setHusbandPatronymic(String husbandPatronymic) {
        this.husbandPatronymic = husbandPatronymic;
    }

    public LocalDate getHusbandBirthDay() {
        return husbandBirthDay;
    }

    public void setHusbandBirthDay(LocalDate husbandBirthDay) {
        this.husbandBirthDay = husbandBirthDay;
    }

    public String getHusbandPassportSerial() {
        return husbandPassportSerial;
    }

    public void setHusbandPassportSerial(String husbandPassportSerial) {
        this.husbandPassportSerial = husbandPassportSerial;
    }

    public String getHusbandPassportNumber() {
        return husbandPassportNumber;
    }

    public void setHusbandPassportNumber(String husbandPassportNumber) {
        this.husbandPassportNumber = husbandPassportNumber;
    }

    public LocalDate getHusbandPassportDate() {
        return husbandPassportDate;
    }

    public void setHusbandPassportDate(LocalDate husbandPassportDate) {
        this.husbandPassportDate = husbandPassportDate;
    }

    public String getWifeSurName() {
        return wifeSurName;
    }

    public void setWifeSurName(String wifeSurName) {
        this.wifeSurName = wifeSurName;
    }

    public String getWifeGivenName() {
        return wifeGivenName;
    }

    public void setWifeGivenName(String wifeGivenName) {
        this.wifeGivenName = wifeGivenName;
    }

    public String getWifePatronymic() {
        return wifePatronymic;
    }

    public void setWifePatronymic(String wifePatronymic) {
        this.wifePatronymic = wifePatronymic;
    }

    public LocalDate getWifeBirthDay() {
        return wifeBirthDay;
    }

    public void setWifeBirthDay(LocalDate wifeBirthDay) {
        this.wifeBirthDay = wifeBirthDay;
    }

    public String getWifePassportSerial() {
        return wifePassportSerial;
    }

    public void setWifePassportSerial(String wifePassportSerial) {
        this.wifePassportSerial = wifePassportSerial;
    }

    public String getWifePassportNumber() {
        return wifePassportNumber;
    }

    public void setWifePassportNumber(String wifePassportNumber) {
        this.wifePassportNumber = wifePassportNumber;
    }

    public LocalDate getWifePassportDate() {
        return wifePassportDate;
    }

    public void setWifePassportDate(LocalDate wifePassportDate) {
        this.wifePassportDate = wifePassportDate;
    }

    public String getMarriageCertNumber() {
        return marriageCertNumber;
    }

    public void setMarriageCertNumber(String marriageCertNumber) {
        this.marriageCertNumber = marriageCertNumber;
    }

    public LocalDate getMarriageCertDate() {
        return marriageCertDate;
    }

    public void setMarriageCertDate(LocalDate marriageCertDate) {
        this.marriageCertDate = marriageCertDate;
    }
}
