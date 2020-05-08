package mts.register.view;

import java.io.Serializable;
import java.time.LocalDate;

public class MarriageResponse implements Serializable {

    private boolean existing;

    public boolean isExisting() {
        return existing;
    }

    public void setExisting(boolean existing) {
        this.existing = existing;
    }

    //
//    private String husbandSurName;
//    private String husbandGivenName;
//    private String husbandPatronymic;
//    private LocalDate husbandBirthDay;
//    private String husbandPassportSerial;
//    private String husbandPassportNumber;
//    private LocalDate husbandPassportDate;
//
//    private String wifeSurName;
//    private String wifeGivenName;
//    private String wifePatronymic;
//    private LocalDate wifeBirthDay;
//    private String wifePassportSerial;
//    private String wifePassportNumber;
//    private LocalDate wifePassportDate;
//
//    private String marriageCertNumber;
//    private LocalDate marriageCertDate;

}
