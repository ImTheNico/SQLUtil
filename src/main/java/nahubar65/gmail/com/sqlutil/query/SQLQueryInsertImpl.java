package nahubar65.gmail.com.sqlutil.query;

import nahubar65.gmail.com.sqlutil.query.abstraction.SQLQueryInsert;
import nahubar65.gmail.com.sqlutil.query.argument.QueryArgumentResolver;
import nahubar65.gmail.com.sqlutil.statement.StatementValue;
import nahubar65.gmail.com.sqlutil.query.argument.SimpleQueryArgumentResolver;
import nahubar65.gmail.com.sqlutil.utils.SQLUtils;

import java.util.ArrayList;
import java.util.List;

public final class SQLQueryInsertImpl implements SQLQueryInsert {

    private String table_name;

    private final List<StatementValue> statementValues = new ArrayList<>();

    private static final String SYNTAX = "INSERT INTO %table_name% VALUES(%values%)";

    SQLQueryInsertImpl() {}

    @Override
    public String getQuery() {
        if (table_name == null)
            throw new NullPointerException("The table is null");

        if (getArguments().isEmpty())
            throw new UnsupportedOperationException("The values are null");

        return SYNTAX.replace("%table_name%", table_name)
            .replace("%values%", getQueryArgumentResolver().resolve());
    }

    @Override
    public SQLQueryInsert setTable(String table) {
        this.table_name = SQLUtils.protectTable(table);
        return this;
    }

    @Override
    public QueryArgumentResolver getQueryArgumentResolver() {
        return new SimpleQueryArgumentResolver(statementValues.size());
    }

    @Override
    public List getArguments() {
        return statementValues;
    }
}