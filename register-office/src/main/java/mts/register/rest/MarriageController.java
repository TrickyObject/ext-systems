package mts.register.rest;

import mts.register.business.MarriageManager;
import mts.register.view.MarriageRequest;
import mts.register.view.MarriageResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("controller")
public class MarriageController {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(MarriageController.class);

    @Autowired // связь с другими объектами. Можно использовать без сеттеров, но это плохо
    @Qualifier("marriageService") // квалификатор. Указывает, какой именно объект надо подлкючить
    private MarriageManager marriageManager;

    public MarriageResponse findMarriageCert (MarriageRequest request) {
        LOGGER.info("findMarriageCert called..");
        return marriageManager.findMarriageCert(request);
    }

    public void setMarriageManager(MarriageManager marriageManager) {
        this.marriageManager = marriageManager;
    }

}
