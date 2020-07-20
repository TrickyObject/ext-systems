package mts.marriage.domain.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@DiscriminatorValue("1")
public class PersonFemale extends Person {

    @OneToMany(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY, mappedBy = "wife")
    private List<MarriageCert> marriageCerts;
    @OneToMany(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY, mappedBy = "mother")
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
