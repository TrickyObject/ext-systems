package mts.register.business;

import mts.register.dao.MarriageDao;
import mts.register.dao.PersonDao;
import mts.register.domain.MarriageCert;
import mts.register.view.MarriageRequest;
import mts.register.view.MarriageResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service("marriageService")
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON) // количество создаваемых объектов, если 1, то Синглтон
public class MarriageManager {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(MarriageManager.class);

    @Autowired
    private MarriageDao marriageDao;

    @Autowired
    private PersonDao personDao;


    public MarriageResponse findMarriageCert(MarriageRequest request) {

        LOGGER.info("findMarriageCert called..");

        MarriageCert cert = marriageDao.findMarriageCert(request);

        return new MarriageResponse();

    }

    public void setMarriageDao(MarriageDao marriageDao) {
        this.marriageDao = marriageDao;
    }
}
