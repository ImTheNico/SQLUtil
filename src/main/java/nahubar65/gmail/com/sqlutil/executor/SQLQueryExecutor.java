package nahubar65.gmail.com.sqlutil.executor;

import nahubar65.gmail.com.sqlutil.result.Result;
import nahubar65.gmail.com.sqlutil.query.SQLQuery;

import java.sql.Connection;

public interface SQLQueryExecutor {

    Result executeQuery(SQLQuery sqlQuery);

    boolean exists(SQLQuery sqlQuery);

    void executeUpdate(SQLQuery sqlQuery);

    static SQLQueryExecutor newExecutor(Connection connection) {
        return new SimpleSQLExecutor(connection);
    }
}