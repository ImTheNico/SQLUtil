package nahubar65.gmail.com.sqlutil.query;

import nahubar65.gmail.com.sqlutil.query.argument.QueryArgumentResolver;
import nahubar65.gmail.com.sqlutil.statement.StatementValue;

import java.util.List;

public interface ArgumentDependent extends SQLQuery {

    QueryArgumentResolver getQueryArgumentResolver();

    List<StatementValue> getArguments();

    default ArgumentDependent addArguments(StatementValue... statementValues) {
        for (StatementValue statementValue : statementValues) {
            getArguments().add(statementValue);
        }
        return this;
    }
}