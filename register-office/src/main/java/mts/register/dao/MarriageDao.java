package mts.register.dao;

import mts.register.domain.MarriageCert;
import mts.register.view.MarriageRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;


@Component // аналог service аннотации. То, что должно быть загружено
public class MarriageDao {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(MarriageDao.class);

    private EntityManager entityManager;
    // сделать запрос к сертификату, который включает все необходимые поля

    @Value("${test.value}")
    private String test;

    public void setTest(String test) {
        this.test = test;
    }

    public MarriageCert findMarriageCert(MarriageRequest request) {
        LOGGER.info("findMarriageCert called.. " + test);

        // TODO
        return new MarriageCert();
    }
}
