package mts.marriage.web;

import mts.marriage.business.RegistryOfficeManager;
import mts.marriage.view.MarriageRequest;
import mts.marriage.view.MarriageResponse;
import mts.marriage.view.ParentsRequest;
import mts.marriage.view.ParentsResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/check")
@Singleton
public class CheckMarriageService {

    private static final Logger logger = LoggerFactory.getLogger(CheckMarriageService.class);

    RegistryOfficeManager registryOfficeManager;

    @PostConstruct
    public void init() {
        logger.info("======> Инициализация менеджера.. ");
        registryOfficeManager = new RegistryOfficeManager();
    }

    @POST
    @Path("marriage")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public MarriageResponse checkMarriageCert(MarriageRequest request) {

        logger.info("Запрос checkMarriageCert: " + request);

        return registryOfficeManager.findMarriageCert(request);
    }

    @POST
    @Path("parent")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public ParentsResponse checkBirthCert(ParentsRequest request) {

        logger.info("Запрос checkBirthCert: " + request);

        return registryOfficeManager.findBirthCert(request);
    }
}
