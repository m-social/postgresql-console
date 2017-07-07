package com.msocial.pgconsole;

import com.zaxxer.hikari.HikariDataSource;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author M-Social <info@msocialproduction.com>
 */
public class App {
    private static final Logger log = LoggerFactory.getLogger(App.class.getName());
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        HikariDataSource ds = new HikariDataSource();
        ds.setJdbcUrl("jdbc:postgresql://localhost/users");
        ds.setUsername("user");
        ds.setPassword("password");
        
        QueryRunner run = new QueryRunner(ds);
        try {
            List<Map<String, Object>> rows = run.query("SELECT * FROM users", new MapListHandler());
            rows.stream().forEach((Map<String, Object> row) -> {
                log.info("row: " + row.toString());
            });
        } catch(SQLException ex) {
            log.error("", ex);
        }

    }
    
}
