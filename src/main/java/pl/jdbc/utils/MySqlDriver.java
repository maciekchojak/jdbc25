package pl.jdbc.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlDriver {
    private static final String user = "root";
    private static final String url = "jdbc:mysql://172.21.1.1:3306/citizens";
    private static final String password = "passw";

    public MySqlDriver() {
    }

    public static Connection createConnection() {
        Connection con = null;

        try {
            con = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
}
