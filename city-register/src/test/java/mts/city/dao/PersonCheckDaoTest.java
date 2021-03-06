package mts.city.dao;

import mts.city.dao.old.PersonCheckDao;
import mts.city.domain.PersonRequest;
import mts.city.domain.PersonResponse;
import mts.city.exception.PersonCheckException;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

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
        pr.setExtension("2");
        pr.setApartment("141");

        PersonCheckDao dao = new PersonCheckDao();
        dao.setConnectionBuilder(new DirectConnectionBuilder());
        PersonResponse ps = dao.checkPerson(pr);

        Assert.assertTrue(ps.isRegistered());
        Assert.assertFalse(ps.isTemporal());

    }

//    @Test
//    public void checkPerson2() throws PersonCheckException {
//        PersonRequest pr = new PersonRequest();
//        pr.setSurName("Васильева");
//        pr.setGivenName("Ирина");
//        pr.setPatronymicName("Петровна");
//        pr.setDateOfBirth(LocalDate.of(1997, 8, 21));
//        pr.setStreetCode(1);
//        pr.setBuilding("271");
//        pr.setExtention("null");
//        pr.setApartment("null");
//
//        PersonCheckDao dao = new PersonCheckDao();
//        PersonResponse ps = dao.checkPerson(pr);
//        Assert.assertTrue(ps.isRegistered());
//        Assert.assertFalse(ps.isTemporal());
//
//    }
}