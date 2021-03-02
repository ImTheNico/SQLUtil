package nahubar65.gmail.com.sqlutil.database;

import nahubar65.gmail.com.sqlutil.sql.table.SQLTable;
import nahubar65.gmail.com.sqlutil.sql.table.DefaultSQLTable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class SimpleDatabaseDataImpl implements DatabaseData {

    private final Connection connection;

    public SimpleDatabaseDataImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Connection getConnection() {
        return connection;
    }

    @Override
    public Map<String, SQLTable> getTables() {
        Map<String, SQLTable> sqlTables = new LinkedHashMap<>();
        try {
            if (!connection.isClosed()) {
                PreparedStatement preparedStatement = connection.prepareStatement("SHOW TABLES");
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    String name = resultSet.getString(1);
                    sqlTables.put(name, new DefaultSQLTable(name, connection));
                }
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return sqlTables;
    }
}