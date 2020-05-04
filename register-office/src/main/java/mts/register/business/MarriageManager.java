package mts.register.business;

import mts.register.dao.MarriageDao;
import mts.register.dao.PersonDao;
import mts.register.domain.MarriageCert;
import mts.register.domain.Person;
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

        MarriageCert cert = marriageDao.findMarriageCert(request);
        personDao.findPerson();

        personDao.addPerson(getPerson());

        return new MarriageResponse();

    }

    private Person getPerson() {
        Person m = new PersonMale();
        m.setFirstName("1");
        m.setLastName("2");
        m.setPatronymic("3");
        m.setDateOfBirth(LocalDate.of(1993, 3, 12));
        return m;
    }
}
