package nahubar65.gmail.com.sqlutil.sql.table;

import nahubar65.gmail.com.sqlutil.sql.column.SQLColumn;
import nahubar65.gmail.com.sqlutil.sql.column.SQLColumnImpl;

import java.sql.*;
import java.util.*;

final class DefaultSQLTableData implements SQLTableData {

    private int columnCount;

    private Set<SQLColumn> sqlColumnSet;

    private final SQLTable sqlTable;

    DefaultSQLTableData(SQLTable sqlTable, Connection connection) {
        this.sqlTable = sqlTable;
        Set<SQLColumn> sqlColumns = new HashSet<>();

        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM " + sqlTable.getIdentifier())) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
                for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
                    SQLColumn sqlColumn = new SQLColumnImpl(resultSetMetaData.getColumnName(i),
                            resultSetMetaData.getColumnTypeName(i),
                            resultSetMetaData.getColumnClassName(i),
                            sqlTable,
                            resultSetMetaData.getCatalogName(i));
                    sqlColumns.add(sqlColumn);
                }

                this.sqlColumnSet = Collections.unmodifiableSet(sqlColumns);
                this.columnCount = resultSetMetaData.getColumnCount();
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    @Override
    public  Set<SQLColumn> getColumns() {
        return sqlColumnSet;
    }

    @Override
    public int getColumnCount() {
        return columnCount;
    }

    @Override
    public SQLTable getTable() {
        return sqlTable;
    }
}