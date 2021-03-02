package nahubar65.gmail.com.sqlutil.sql.table;

import nahubar65.gmail.com.sqlutil.sql.column.SQLColumn;

import java.util.Set;

public interface SQLTableData {

    Set<SQLColumn> getColumns();

    int getColumnCount();

    SQLTable getTable();
}