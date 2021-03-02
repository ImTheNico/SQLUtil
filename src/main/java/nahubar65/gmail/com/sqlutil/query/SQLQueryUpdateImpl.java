package nahubar65.gmail.com.sqlutil.query;

import nahubar65.gmail.com.sqlutil.query.abstraction.SQLQueryUpdate;
import nahubar65.gmail.com.sqlutil.query.argument.QueryArgumentResolver;
import nahubar65.gmail.com.sqlutil.query.clause.WhereClause;
import nahubar65.gmail.com.sqlutil.query.argument.FieldQueryArgumentResolver;
import nahubar65.gmail.com.sqlutil.utils.SQLUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class SQLQueryUpdateImpl extends QueryArgumentDependentImpl implements SQLQueryUpdate {

    private String table_name;

    private WhereClause whereClause;

    private final List<String> fieldList = new ArrayList<>();

    private static final String SYNTAX = "UPDATE %table_name% SET %values% %conditional_expression%";

    SQLQueryUpdateImpl() {}

    @Override
    public SQLQueryUpdate setTable(String table) {
        this.table_name = table;
        return this;
    }

    @Override
    public SQLQueryUpdate setWhereClause(WhereClause whereClause) {
        this.whereClause = whereClause;
        return this;
    }

    @Override
    public SQLQueryUpdate addArgumentField(String... fields) {
        fieldList.addAll(Arrays.asList(fields));
        return this;
    }

    @Override
    public String getQuery() {
        if (table_name == null)
            throw new NullPointerException("The table is null");

        if (getArguments().isEmpty())
            throw new UnsupportedOperationException("The values are null");

        return SYNTAX.replace("%table_name%", SQLUtils.protectTable(table_name))
                .replace("%values%", getQueryArgumentResolver().resolve())
                .replace("%conditional_expression%", whereClause != null ? whereClause.getClause() : "");
    }

    @Override
    public QueryArgumentResolver getQueryArgumentResolver() {
        return new FieldQueryArgumentResolver(fieldList.toArray(new String[0]));
    }
}