package mts.city.web;

import mts.city.dao.PersonCheckDao;
import mts.city.dao.PoolConnectionBuilder;
import mts.city.domain.PersonRequest;
import mts.city.domain.PersonResponse;
import mts.city.exception.PersonCheckException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.time.LocalDate;

@Path("/check")
@Singleton
public class CheckPersonService {

    private static final Logger logger = LoggerFactory.getLogger(CheckPersonService.class);
    private PersonCheckDao dao;

    // Выполняется после создания объекта
    @PostConstruct
    public void init() {
        logger.info("SERVICE CREATED..");
        dao = new PersonCheckDao();
        dao.setConnectionBuilder(new PoolConnectionBuilder());
    }

    //  Выполняется перед уничтожением объекта
    @PreDestroy
    public void destroy() {
        logger.info("END");
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public PersonResponse checkPerson(PersonRequest request) throws PersonCheckException {
        logger.info(request.toString());
        return dao.checkPerson(request);
    }

}


/*



 */