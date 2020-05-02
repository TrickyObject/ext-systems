package mts.register.domain;

import javax.persistence.*;
import java.util.List;
@Entity
@DiscriminatorValue("2")
public class PersonMale extends Person {

    @OneToMany(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY, mappedBy = "husband")
    private List<MarriageCert> marriageCerts;
    @OneToMany(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY, mappedBy = "father")
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
