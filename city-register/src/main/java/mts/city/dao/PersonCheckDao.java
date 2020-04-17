package mts.city.dao;

import mts.city.domain.PersonRequest;
import mts.city.domain.PersonResponse;
import mts.city.exception.PersonCheckException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

public class PersonCheckDao {

    private static final Logger logger = LoggerFactory.getLogger(PersonCheckDao.class);

    private static final String SQL_REQUEST = "select temporal from cr_adress_person ap " +
            "inner join cr_person p on p.person_id = ap.person_id " +
            "inner join cr_adress a on a.adress_id = ap.adress_id " +
            "where " +
            "CURRENT_DATE >= ap.start_date and (CURRENT_DATE <= ap.END_date or ap.END_date is null)" +
            "and p.sur_name = ? " +
            "and p.given_name  = ? " +
            "and p.patronymic = ? " +
            "and p.date_of_birth = ? " +
            "and a.street_code = ? " +
            "and a.building = ? ";

    private ConnectionBuilder connectionBuilder;

    public void setConnectionBuilder(ConnectionBuilder connectionBuilder) {
        logger.info("Задали билдер ");
        this.connectionBuilder = connectionBuilder;
        if (this.connectionBuilder == null) {
            logger.info("БИЛДЕР ПУСТОЙ");
        } else {
            logger.info("БИЛДЕР НЕ ПУСТОЙ");
        }
    }

    private Connection getConnection() throws SQLException {
        logger.info("Попытка получить коннекшн ");
//      TODO : Тут оно и валится
        return connectionBuilder.getConnection();
    }

    public PersonResponse checkPerson (PersonRequest request) throws PersonCheckException {

        PersonResponse response = new PersonResponse();

        String sql = SQL_REQUEST;

        if (request.getExtention() != null) {
            sql += " and a.extension = ? ";
        } else {
            sql += " and a.extension is null ";
        }

        if (request.getApartment() != null) {
            sql += " and a.apartment = ? ";
        } else {
            sql += " and a.apartment is null ";
        }

        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)
        ) {
            int count = 1;
            ps.setString(count++, request.getSurName());
            ps.setString(count++, request.getGivenName());
            ps.setString(count++, request.getPatronymicName());
            ps.setDate(count++, java.sql.Date.valueOf(request.getDateOfBirth()));
            ps.setInt(count++, request.getStreetCode());
            ps.setString(count++, request.getBuilding());

            if (request.getExtention() != null) {
                ps.setString(count++, request.getExtention());
            }
            if (request.getApartment() != null) {
                ps.setString(count, request.getApartment());
            }

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                response.setRegistered(true);
                response.setTemporal(rs.getBoolean("temporal"));
            }

        } catch (SQLException ex) {
            throw new PersonCheckException(ex);
        }

        return response;
    }
}

/*
private static final String SQL_REQUEST = "select temporal from cr_adress_person ap " +
            "inner join cr_person p on p.person_id = ap.person_id " +
            "inner join cr_adress a on a.adress_id = ap.adress_id " +
            "where " +
            "CURRENT_DATE >= ap.start_date and (CURRENT_DATE <= ap.END_date or ap.END_date is null)" +
            "and upper(p.sur_name COLLATE \"ru_RU.UTF-8\") = upper(? COLLATE \"ru_RU.UTF-8\") " +
            "and upper(p.given_name COLLATE  \"ru_RU.UTF-8\") = upper(? COLLATE  \"ru_RU.UTF-8\") " +
            "and upper(patronymic COLLATE  \"ru_RU.UTF-8\") = upper(? COLLATE  \"ru_RU.UTF-8\") " +
            "and p.date_of_birth = ? " +
            "and a.street_code = ? " +
            "and upper(a.building COLLATE  \"ru_RU.UTF-8\") = upper(? COLLATE  \"ru_RU.UTF-8\") ";
 */