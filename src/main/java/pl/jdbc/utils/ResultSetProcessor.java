package pl.jdbc.utils;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ResultSetProcessor {
    private final ResultSet resultSet;
    private String tableName;
    private final List<String> columnNames = new ArrayList<>();


    public ResultSetProcessor(ResultSet resultSet) {
        this.resultSet = resultSet;
    }

    public void processResultSet() throws SQLException {
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();

        getTableName(metaData);
        getColumnsName(metaData, columnCount, columnNames);

        System.out.printf("Get all values from table: %s \n", tableName);
        System.out.printf("%s %s %s %s %s %s %s \n", columnNames.get(0), columnNames.get(1), columnNames.get(2), columnNames.get(3), columnNames.get(4), columnNames.get(5), columnNames.get(6));

        printResultSet(columnCount);
    }

    private void printResultSet(int columnCount) throws SQLException {
        while (resultSet.next()) {

            for (int i = 1; i <= columnCount; i++) {

                String columnData;
                if (resultSet.getObject(i) != null) {
                    columnData = resultSet.getObject(i).toString();
                } else {
                    columnData = "NULL";
                }
                System.out.print(columnData + " ");
            }

            System.out.println();
        }
        resultSet.close();
    }

    private void getTableName(ResultSetMetaData metaData) throws SQLException {
        tableName = metaData.getTableName(1);
    }

    private void getColumnsName(ResultSetMetaData metaData, int columnCount, List<String> columnNames) throws SQLException {
        for (int i = 1; i <= columnCount; i++) {
            columnNames.add(metaData.getColumnName(i));
        }
    }
}
