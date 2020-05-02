package mts.register.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Table(name = "ro_person")
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // стиль представления в бд наследованых таблиц
@DiscriminatorColumn(name = "sex", discriminatorType = DiscriminatorType.INTEGER)
// выгодно в высоконагруженной системе
// параметры через ":personId"
// FETCH сразу подтягивает
@NamedQueries({
        @NamedQuery(name = "Person.findPersons",
                query = "SELECT p FROM Person p " +
                        "LEFT JOIN FETCH p.passports " +
                        "LEFT JOIN FETCH p.birthCert " +
                        "WHERE p.personId = :personId")
})
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private Long personId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "patronymic")
    private String patronymic;
    @Column(name = "date_birth")
    private LocalDate dateOfBirth;
    @OneToOne(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY,
            mappedBy = "person")
    private BirthCert birthCert;
    @OneToMany(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY, mappedBy = "person") // отношение между таблицами
    private List<Passport> passports;



    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public List<Passport> getPassports() {
        return passports;
    }

    public void setPassports(List<Passport> passports) {
        this.passports = passports;
    }

    public BirthCert getBirthCert() {
        return birthCert;
    }

    public void setBirthCert(BirthCert birthCert) {
        this.birthCert = birthCert;
    }
}
