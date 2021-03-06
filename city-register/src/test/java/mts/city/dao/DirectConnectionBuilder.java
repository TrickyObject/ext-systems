package mts.city.dao;

import mts.city.dao.old.ConnectionBuilder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DirectConnectionBuilder implements ConnectionBuilder {


    @Override
    public Connection getConnection() throws SQLException {

        return DriverManager.getConnection("jdbc:postgresql://localhost/city_register",
                "postgres",
                "root");
    }
}
