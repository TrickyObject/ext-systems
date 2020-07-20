package mts.marriage.business;


import mts.marriage.dao.MarriageDao;
import mts.marriage.view.MarriageRequest;
import mts.marriage.view.MarriageResponse;
import mts.marriage.view.ParentsRequest;
import mts.marriage.view.ParentsResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class RegistryOfficeManager {

    private static final Logger logger = LoggerFactory.getLogger(RegistryOfficeManager.class);

    private static final String HQL_MARRIAGE_REQUEST = "select mc.marriageCertId from MarriageCert mc " +
            "inner join Person pH on pH.personId = mc.husband " +
            "inner join Person pW on pW.personId = mc.wife " +
            "inner join Passport dH on dH.person = pH.personId " +
            "inner join Passport dW on dW.person = pW.personId " +
            "where " +
            "mc.issueDate <= CURRENT_DATE and mc.endDate is null " +

            "and pH.firstName  = ?1 " +
            "and pH.lastName  = ?2 " +
            "and pH.patronymic  = ?3 " +
            "and pH.dateOfBirth  = ?4 " +
            "and dH.serial  = ?5 " +
            "and dH.number  = ?6 " +
            "and dH.issueDate  = ?7 " +

            "and pW.firstName  = ?8 " +
            "and pW.lastName  = ?9 " +
            "and pW.patronymic  = ?10 " +
            "and pW.dateOfBirth  = ?11 " +
            "and dW.serial  = ?12 " +
            "and dW.number  = ?13 " +
            "and dW.issueDate  = ?14 " +

            "and mc.number = ?15 " +
            "and mc.issueDate = ?16 ";

    private static final String HQL_CERT = "select mc.marriageCertId from MarriageCert mc " +
            "where " +
            "mc.issueDate <= CURRENT_DATE and mc.endDate is null " +
            "and mc.number = ?1 " +
            "and mc.issueDate = ?2";

    private static final String HQL_PARENT_REQUEST = "select bc.birthCertId from BirthCert bc " +
            "inner join Person pF on pF.personId = bc.father " +
            "inner join Person pM on pM.personId = bc.mother " +
            "inner join Passport dF on dF.person = pF.personId " +
            "inner join Passport dM on dM.person = pM.personId " +
            "where " +
            "bc.issueDate <= CURRENT_DATE " +

            "and pF.firstName  = ?1 " +
            "and pF.lastName  = ?2 " +
            "and pF.patronymic  = ?3 " +
            "and pF.dateOfBirth  = ?4 " +
            "and dF.serial  = ?5 " +
            "and dF.number  = ?6 " +
            "and dF.issueDate  = ?7 " +

            "and pM.firstName  = ?8 " +
            "and pM.lastName  = ?9 " +
            "and pM.patronymic  = ?10 " +
            "and pM.dateOfBirth  = ?11 " +
            "and dM.serial  = ?12 " +
            "and dM.number  = ?13 " +
            "and dM.issueDate  = ?14 " +

            "and bc.number = ?15 " +
            "and bc.issueDate = ?16 ";

    private MarriageDao marriageDao;

    public RegistryOfficeManager() {

        logger.info("======> Инициализация DAO.. ");
        marriageDao = new MarriageDao();
    }

    public ParentsResponse findBirthCert(ParentsRequest request) {

        logger.info("findBirthCert");

        EntityManager em = getEntityManager();
        ParentsResponse response = new ParentsResponse();

        String hql = HQL_PARENT_REQUEST;

        Query query = em.createQuery(hql);
        setBirthCertQueryParam(query, request);


        logger.info(""+query.getParameters().toString());
        List resultList = query.getResultList();

        logger.info(""+resultList.toString());

        if (resultList.size() == 1) {
            response.setExisting(true);
        }

        em.close();

        logger.info("Ответ: " + response.toString());

        return response;
    }

    public MarriageResponse findMarriageCert(MarriageRequest request) {

        logger.info("findMarriageCert");

        EntityManager em = getEntityManager();
        MarriageResponse response = new MarriageResponse();

        String hql = HQL_MARRIAGE_REQUEST;
//        String hql = HQL_CERT;

        Query query = em.createQuery(hql);
        setMarriageCertQueryParam(query, request);


        logger.info(""+query.getParameters().toString());
        List resultList = query.getResultList();
        logger.info(""+resultList.toString());

        if (resultList.size() == 1) {
            response.setExisting(true);
        }

        em.close();

        logger.info("Ответ: " + response.toString());

        return response;

    }

    private Query setMarriageCertQueryParam(Query query, MarriageRequest request) {

        int count = 1;

        logger.info("setMarriageCertQueryParam");

        query.setParameter(count++, request.getHusbandGivenName());
        query.setParameter(count++, request.getHusbandSurName());
        query.setParameter(count++, request.getHusbandPatronymic());
        query.setParameter(count++, request.getHusbandBirthDay());
        query.setParameter(count++, request.getHusbandPassportSerial());
        query.setParameter(count++, request.getHusbandPassportNumber());
        query.setParameter(count++, request.getHusbandPassportDate());

        query.setParameter(count++, request.getWifeGivenName());
        query.setParameter(count++, request.getWifeSurName());
        query.setParameter(count++, request.getWifePatronymic());
        query.setParameter(count++, request.getWifeBirthDay());
        query.setParameter(count++, request.getWifePassportSerial());
        query.setParameter(count++, request.getWifePassportNumber());
        query.setParameter(count++, request.getWifePassportDate());

        query.setParameter(count++, request.getMarriageCertNumber());
        query.setParameter(count++, request.getMarriageCertDate());

        logger.info("setMarriageCertQueryParam: "
                + request.getHusbandGivenName() + " "
                + request.getHusbandSurName() + " "
                + request.getHusbandPatronymic() + " "
                + request.getHusbandBirthDay() + " "
                + request.getHusbandPassportSerial() + " "
                + request.getHusbandPassportNumber() + " "
                + request.getHusbandPassportDate() + " "

                + request.getWifeGivenName() + " "
                + request.getWifeSurName() + " "
                + request.getWifePatronymic() + " "
                + request.getWifeBirthDay() + " "
                + request.getWifePassportSerial() + " "
                + request.getWifePassportNumber() + " "
                + request.getWifePassportDate() + " "

                + request.getMarriageCertNumber() + " "
                + request.getMarriageCertDate());

        return query;
    }

    private Query setBirthCertQueryParam(Query query, ParentsRequest request) {

        int count = 1;

        logger.info("setBirthCertQueryParam");

        query.setParameter(count++, request.getFatherGivenName());
        query.setParameter(count++, request.getFatherSurName());
        query.setParameter(count++, request.getFatherPatronymic());
        query.setParameter(count++, request.getFatherBirthDay());
        query.setParameter(count++, request.getFatherPassportSerial());
        query.setParameter(count++, request.getFatherPassportNumber());
        query.setParameter(count++, request.getFatherPassportDate());

        query.setParameter(count++, request.getMotherGivenName());
        query.setParameter(count++, request.getMotherSurName());
        query.setParameter(count++, request.getMotherPatronymic());
        query.setParameter(count++, request.getMotherBirthDay());
        query.setParameter(count++, request.getMotherPassportSerial());
        query.setParameter(count++, request.getMotherPassportNumber());
        query.setParameter(count++, request.getMotherPassportDate());

        query.setParameter(count++, request.getParentCertNumber());
        query.setParameter(count++, request.getParentCertDate());

        logger.info("setMarriageCertQueryParam: "
                + request.getFatherGivenName() + " "
                + request.getFatherSurName() + " "
                + request.getFatherPatronymic() + " "
                + request.getFatherBirthDay() + " "
                + request.getFatherPassportSerial() + " "
                + request.getFatherPassportNumber() + " "
                + request.getFatherPassportDate() + " "

                + request.getMotherGivenName() + " "
                + request.getMotherSurName() + " "
                + request.getMotherPatronymic() + " "
                + request.getMotherBirthDay() + " "
                + request.getMotherPassportSerial() + " "
                + request.getMotherPassportNumber() + " "
                + request.getMotherPassportDate() + " "

                + request.getParentCertNumber() + " "
                + request.getParentCertDate());

        return query;
    }

    private EntityManager getEntityManager() {
        return marriageDao.getEntityManager();
    }

}
