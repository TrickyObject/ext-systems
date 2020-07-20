package mts.student.web;

import mts.student.business.StudentRegisterManager;
import mts.student.view.StudentRequest;
import mts.student.view.StudentResponse;
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
public class CheckStudentService {

    private static final Logger logger = LoggerFactory.getLogger(CheckStudentService.class);

    StudentRegisterManager studentRegisterManager;

    @PostConstruct
    public void init() {
        logger.info("======> Инициализация менеджера.. ");
        studentRegisterManager = new StudentRegisterManager();
    }

    @POST
    @Path("mts/student")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public StudentResponse checkStudent(StudentRequest request) {

        logger.info("===================================>");
        logger.info("===================================>");
        logger.info("===================================>");
        logger.info("===================================> Начинаем обработку запроса.. ");
        logger.info("Запрос: " + request);

        return studentRegisterManager.findStudent(request);
    }

}
