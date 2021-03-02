package nahubar65.gmail.com.sqlutil.query;

import nahubar65.gmail.com.sqlutil.query.abstraction.SQLQuerySelect;
import nahubar65.gmail.com.sqlutil.query.clause.WhereClause;

import java.util.ArrayList;
import java.util.List;

public final class SQLQuerySelectImpl implements SQLQuerySelect {

    private final List<String> fieldList = new ArrayList<>();

    private String table_name;

    private WhereClause whereClause;

    private static final String SYNTAX = "SELECT %values% FROM %table_name% %conditional_expression%";

    SQLQuerySelectImpl() {}

    @Override
    public SQLQuerySelect addField(String... values) {
        for (String value : values) {
            fieldList.add(value);
        }
        return this;
    }

    @Override
    public SQLQuerySelect setTable(String table) {
        this.table_name = table;
        return this;
    }

    @Override
    public SQLQuerySelect setWhereClause(WhereClause whereClause) {
        this.whereClause = whereClause;
        return this;
    }

    @Override
    public String getQuery() {
        if (fieldList.isEmpty())
            fieldList.add("*");

        if (table_name == null)
            throw new NullPointerException("The table is null");

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < fieldList.size(); i++) {
            String field = fieldList.get(i);

            if (i > 0)
                stringBuilder.append(",");

            stringBuilder.append(field);
        }

        return SYNTAX.replace("%values%", stringBuilder.toString())
                .replace("%table_name%", table_name)
                .replace("%conditional_expression%", whereClause != null ? whereClause.getClause() : "");
    }
}