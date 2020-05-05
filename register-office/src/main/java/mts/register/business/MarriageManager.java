package mts.register.business;

import mts.register.dao.MarriageDao;
import mts.register.dao.PersonDao;
import mts.register.domain.MarriageCert;
import mts.register.domain.Person;
import mts.register.domain.PersonFemale;
import mts.register.domain.PersonMale;
import mts.register.view.MarriageRequest;
import mts.register.view.MarriageResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service("marriageService")
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON) // количество создаваемых объектов, если 1, то Синглтон
public class MarriageManager {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(MarriageManager.class);

    @Autowired
    private MarriageDao marriageDao;
    @Autowired
    private PersonDao personDao;

    //отвечает за включение в транзацию
    // сделает rollback
    // выкинет exception
    @Transactional
    public MarriageResponse findMarriageCert(MarriageRequest request) {
        LOGGER.info("findMarriageCert called..");

//        MarriageCert cert = marriageDao.findMarriageCert(request);
        personDao.findPerson();

        personDao.addPerson(getPerson(1));
        personDao.addPerson(getPerson(2));

        MarriageCert mc = getMarriageCertificate();
        marriageDao.saveAndFlush(mc);
        marriageDao.findAll();

        return new MarriageResponse();

    }

    private MarriageCert getMarriageCertificate() {

        MarriageCert mc = new MarriageCert();
        mc.setIssueDate(LocalDate.now());
        mc.setNumber("12345");
        mc.setActive(true);

        List<Person> persons = personDao.findPerson();
        for (Person person : persons) {
            if (person instanceof PersonMale) {
                mc.setHusband((PersonMale) person);
            } else {
                mc.setWife((PersonFemale) person);
            }
        }

        return mc;

    }

    private Person getPerson(int sex) {
        Person m = sex == 1 ? new PersonFemale() : new PersonMale();
        m.setFirstName("1_" + sex);
        m.setLastName("2_" + sex);
        m.setPatronymic("3_" + sex);
        m.setDateOfBirth(LocalDate.of(1993, 3, 12));
        return m;
    }
}
