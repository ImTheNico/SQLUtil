package nahubar65.gmail.com.sqlutil.sql.column;

import nahubar65.gmail.com.sqlutil.sql.table.SQLTable;

public interface SQLColumn {

    String getName();

    String getType();

    String getClassName();

    SQLTable getTable();

    String getCatalogName();
}