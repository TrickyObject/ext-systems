package mts.register.dao;

import junit.framework.TestCase;
import mts.register.domain.Person;
import mts.register.domain.PersonFemale;
import mts.register.domain.PersonMale;
import org.junit.Test;

import java.util.List;

public class PersonDaoTest extends TestCase {

    @Test
    public void testFindPerson() {
        PersonDao dao = new PersonDao();
        List<Person> persons = dao.findPerson();

        persons.forEach(person1 -> {
            System.out.println("Name: " + person1.getFirstName());
            System.out.println("Class for sex: " + person1.getClass());
            System.out.println("Passports: " + person1.getPassports().size());
            System.out.println("Birth: " + person1.getBirthCert());
            if (person1 instanceof PersonMale) {
                System.out.println("Birth certs: " + ((PersonMale) person1).getBirthCerts().size());
                System.out.println("Marriage certs: " + ((PersonMale) person1).getMarriageCerts().size());
            } else {
                System.out.println("Birth certs: " + ((PersonFemale) person1).getBirthCerts().size());
                System.out.println("Marriage certs: " + ((PersonFemale) person1).getMarriageCerts().size());
            }
        });
    }
}