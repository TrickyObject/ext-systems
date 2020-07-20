package mts.student.business;

import mts.student.dao.StudentRegisterDao;
import mts.student.view.StudentRequest;
import mts.student.view.StudentResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;


public class StudentRegisterManager {

    private static final Logger logger = LoggerFactory.getLogger(StudentRegisterManager.class);

    private static final String HQL_STUDENT_REQUEST = "select st.studentId from Student st, StudentDocument std, Faculty f, University u " +
            "where st.id = std.student " +
            "and std.university = u.id " +
            "and std.faculty = f.id " +

            "and st.firstName = ?1 " +
            "and st.lastName = ?2 " +
            "and st.middleName = ?3 " +
            "and st.dateOfBirth = ?4 " +
            "and st.passportSerial = ?5 " +
            "and st.passportNumber = ?6 " +
            "and st.passportDate = ?7 " +

            "and std.documentNumber = ?8 " +
            "and std.documentDate = ?9 " +
            "and std.expiredDate is null " +
            "and u.universityName = ?10 " +
            "and f.facultyName = ?11 ";
//            "and std.faculty = ?11 " + "and std.studentForm = ?12 ";


    private StudentRegisterDao studentRegisterDao;

    public StudentRegisterManager() {

        logger.info("======> Инициализация DAO.. ");
        studentRegisterDao = new StudentRegisterDao();
    }

    public StudentResponse findStudent(StudentRequest request) {

        logger.info("findStudent..");

        EntityManager em = getEntityManager();
        StudentResponse response = new StudentResponse();

        String hql = HQL_STUDENT_REQUEST;

        Query query = em.createQuery(hql);
        setStudentParam(query, request);

        List resultList = query.getResultList();

        logger.info("Result List: " +resultList.toString());

        if (resultList.size() == 1) {
            response.setExisting(true);
        }

        em.close();

        logger.info("Ответ: " + response.isExisting());

        return response;
    }


    private Query setStudentParam(Query query, StudentRequest request) {

        int count = 1;

        logger.info("setStudentParam");

        query.setParameter(count++, request.getFirstName());
        query.setParameter(count++, request.getLastName());
        query.setParameter(count++, request.getMiddleName());
        query.setParameter(count++, request.getDateOfBirth());
        query.setParameter(count++, request.getPassportSerial());
        query.setParameter(count++, request.getPassportNumber());
        query.setParameter(count++, request.getPassportDate());

        query.setParameter(count++, request.getDocumentNumber());
        query.setParameter(count++, request.getDocumentDate());
        query.setParameter(count++, request.getUniversity());
        query.setParameter(count++, request.getFaculty());



        logger.info("setStudentParam: "
                + request.getFirstName() + " "
                + request.getLastName() + " "
                + request.getMiddleName() + " "
                + request.getDateOfBirth() + " "
                + request.getPassportSerial() + " "
                + request.getPassportNumber() + " "
                + request.getPassportDate() + " "
                + request.getDocumentNumber() + " "
                + request.getDocumentDate() + " "
                + request.getUniversity() + " "
                + request.getFaculty() + " "
        );

        return query;
    }


    private EntityManager getEntityManager() {
        return studentRegisterDao.getEntityManager();
    }

}
