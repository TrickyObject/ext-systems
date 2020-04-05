package mts.city.dao;

import mts.city.domain.PersonRequest;
import mts.city.domain.PersonResponse;
import mts.city.exception.PersonCheckException;

import java.sql.*;

public class PersonCheckDao {

    private static final String SQL_REQUEST = "select temporal from cr_adress_person ap " +
            "inner join cr_person p on p.person_id = ap.person_id " +
            "inner join cr_adress a on a.adress_id = ap.adress_id " +
            "where " +
            "upper(p.sur_name COLLATE \"en_US.UTF8\") = upper(? COLLATE \"en_US.UTF8\") " +
            "and upper(p.given_name COLLATE  \"en_US.UTF8\") = upper(? COLLATE  \"en_US.UTF8\") " +
            "and upper(patronymic COLLATE  \"en_US.UTF8\") = upper(? COLLATE  \"en_US.UTF8\") " +
            "and p.date_of_birth = ? " +
            "and a.street_code = ? " +
            "and upper(a.building COLLATE  \"en_US.UTF8\") = upper(? COLLATE  \"en_US.UTF8\") " +
            "and upper(extension COLLATE  \"en_US.UTF8\") = upper(? COLLATE  \"en_US.UTF8\") " +
            "and upper(a.apartment COLLATE  \"en_US.UTF8\") = upper(? COLLATE  \"en_US.UTF8\")";

    public PersonResponse checkPerson (PersonRequest request) throws PersonCheckException {
        PersonResponse response = new PersonResponse();


        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(SQL_REQUEST)
        ) {
            ps.setString(1, request.getSurName());
            ps.setString(2, request.getGivenName());
            ps.setString(3, request.getPatronymicName());
            ps.setDate(4, java.sql.Date.valueOf(request.getDateOfBirth()));
            ps.setInt(5, request.getStreetCode());
            ps.setString(6, request.getBuilding());
            ps.setString(7, request.getExtention());
            ps.setString(8, request.getApartment());

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

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:postgresql://localhost/city_register",
                "postgres",
                "root");
    }
}
