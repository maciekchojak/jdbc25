package pl.jdbc;

import pl.jdbc.utils.MySqlDriver;
import pl.jdbc.utils.ResultSetProcessor;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws Exception {
        Connection connection = MySqlDriver.createConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM citizens.persons");
        ResultSetProcessor rp = new ResultSetProcessor(resultSet);

        rp.processResultSet();

        connection.close();
    }
}
