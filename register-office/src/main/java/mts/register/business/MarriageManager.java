package mts.register.business;

import mts.register.dao.MarriageDao;
import mts.register.domain.MarriageCert;
import mts.register.view.MarriageRequest;
import mts.register.view.MarriageResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MarriageManager {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(MarriageManager.class);

    private MarriageDao marriageDao;

    public MarriageResponse findMarriageCert(MarriageRequest request) {

        LOGGER.info("findMarriageCert called..");

        MarriageCert cert = marriageDao.findMarriageCert(request);

        return new MarriageResponse();

    }

    public void setMarriageDao(MarriageDao marriageDao) {
        this.marriageDao = marriageDao;
    }
}
