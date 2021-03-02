package nahubar65.gmail.com.sqlutil.database;

import nahubar65.gmail.com.sqlutil.sql.table.SQLTable;

import java.sql.Connection;
import java.util.Map;

public interface DatabaseData {

    Connection getConnection();

    Map<String, SQLTable> getTables();

}