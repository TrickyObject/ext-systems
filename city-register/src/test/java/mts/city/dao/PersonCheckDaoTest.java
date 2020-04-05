package mts.city.dao;

import mts.city.domain.PersonRequest;
import mts.city.domain.PersonResponse;
import mts.city.exception.PersonCheckException;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class PersonCheckDaoTest {

    @Test
    public void checkPerson() throws PersonCheckException {
        PersonRequest pr = new PersonRequest();
        pr.setSurName("Васильев");
        pr.setGivenName("Павел");
        pr.setPatronymicName("Николаевич");
        pr.setDateOfBirth(LocalDate.of(1995, 3, 18));
        pr.setStreetCode(1);
        pr.setBuilding("10");
        pr.setExtention("2");
        pr.setApartment("141");

        PersonCheckDao dao = new PersonCheckDao();
        PersonResponse ps = dao.checkPerson(pr);
        Assert.assertTrue(ps.isRegistered());
        Assert.assertFalse(ps.isTemporal());

    }
}