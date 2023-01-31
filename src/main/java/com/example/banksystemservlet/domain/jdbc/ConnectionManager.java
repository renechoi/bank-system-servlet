package work.atm.step3.domain.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

    private static final String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:XE";
    private static final String DB_USERNAME = "webdb";
    private static final String DB_PW = "oracle";

    public static Connection getConnection() {
        try {
            Class.forName(DB_DRIVER);
            System.out.println("DB 접속 성공");
            return DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PW);
        } catch (SQLException | RuntimeException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new IllegalStateException("error");
        }
    }
}
