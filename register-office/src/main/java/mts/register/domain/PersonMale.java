package mts.register.domain;

import java.util.List;

public class PersonMale extends Person {

    private List<MarriageCert> marriageCerts;
    private List<BirthCert> birthCerts;


    public List<MarriageCert> getMarriageCerts() {
        return marriageCerts;
    }

    public void setMarriageCerts(List<MarriageCert> marriageCerts) {
        this.marriageCerts = marriageCerts;
    }

    public List<BirthCert> getBirthCerts() {
        return birthCerts;
    }

    public void setBirthCerts(List<BirthCert> birthCerts) {
        this.birthCerts = birthCerts;
    }
}
