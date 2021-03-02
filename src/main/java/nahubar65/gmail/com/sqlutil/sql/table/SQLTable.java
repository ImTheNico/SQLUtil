package nahubar65.gmail.com.sqlutil.sql.table;

import java.sql.Connection;

public interface SQLTable {

    String getIdentifier();

    SQLTableData getData();

    Connection getConnection();
}