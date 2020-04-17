package mts.city.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class PoolConnectionBuilder implements ConnectionBuilder {

    private static final Logger logger = LoggerFactory.getLogger(PoolConnectionBuilder.class);

    private DataSource dataSource;

    public PoolConnectionBuilder() {
        try {
            Context ctx =  new InitialContext();
            dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/cityRegister");
            logger.info("Дата соурс загружен ");
        } catch (NamingException e) {
            logger.error("ОШИБКА. Дата соурс не загружен", e);
        }
    }

    public Connection getConnection() throws SQLException {
        logger.info("Попытка гет ");
        return this.dataSource.getConnection();

    }
}

/*
try {
            Context ctx =  new InitialContext();
            dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/cityRegister");
        } catch (NamingException e) {
            logger.error("ОШИБКА ", e);
        }
 */
