package mts.register.rest;

import mts.register.business.MarriageManager;
import mts.register.view.MarriageRequest;
import mts.register.view.MarriageResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MarriageController {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(MarriageController.class);

    private MarriageManager marriageManager;

    public MarriageResponse findMarriageCert (MarriageRequest request) {
        LOGGER.info("findMarriageCert called..");
        return marriageManager.findMarriageCert(request);
    }

    public void setMarriageManager(MarriageManager marriageManager) {
        this.marriageManager = marriageManager;
    }

}
