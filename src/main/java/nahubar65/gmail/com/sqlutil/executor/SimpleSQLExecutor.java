package nahubar65.gmail.com.sqlutil.executor;

import nahubar65.gmail.com.sqlutil.query.ArgumentDependent;
import nahubar65.gmail.com.sqlutil.result.Result;
import nahubar65.gmail.com.sqlutil.query.SQLQuery;
import nahubar65.gmail.com.sqlutil.statement.StatementValue;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public final class SimpleSQLExecutor implements SQLQueryExecutor {

    private final Connection connection;

    SimpleSQLExecutor(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Result executeQuery(SQLQuery sqlQuery) {
        try {
            try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery.getQuery())) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    return Result.getResult(resultSet);
                }
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean exists(SQLQuery sqlQuery) {
        try {
            try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery.getQuery())) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    return resultSet.next();
                }
            }
        } catch (SQLException sqlException) {
            return false;
        }
    }

    @Override
    public void executeUpdate(SQLQuery sqlQuery) {
        try {
            if (sqlQuery instanceof ArgumentDependent) {
                ArgumentDependent argumentDependentQuery = (ArgumentDependent) sqlQuery;
                List<StatementValue> statementQueryIndices = argumentDependentQuery.getArguments();
                try (PreparedStatement preparedStatement = setValues(sqlQuery,
                        statementQueryIndices.toArray(new StatementValue[0]))) {

                    preparedStatement.executeUpdate();
                }
            } else {
                try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery.getQuery())) {
                    preparedStatement.executeUpdate();
                }
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    private PreparedStatement setValues(SQLQuery sqlQuery, StatementValue... statementValues) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery.getQuery());

        for (StatementValue statementValue : statementValues) {
            preparedStatement.setObject(statementValue.getIndex(), statementValue.getValue());
        }
        return preparedStatement;
    }
}