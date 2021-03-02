package nahubar65.gmail.com.sqlutil.query;

import nahubar65.gmail.com.sqlutil.query.abstraction.SQLQueryDelete;
import nahubar65.gmail.com.sqlutil.query.clause.WhereClause;

public final class SQLQueryDeleteImpl implements SQLQueryDelete {

    private String table_name;

    private WhereClause whereClause;

    private static final String SYNTAX = "DELETE FROM %table_name% %conditional_expression%";

    SQLQueryDeleteImpl() {}

    @Override
    public SQLQueryDelete setTable(String table) {
        this.table_name = table;
        return this;
    }

    @Override
    public SQLQueryDelete setWhereClause(WhereClause whereClause) {
        this.whereClause = whereClause;
        return this;
    }

    @Override
    public String getQuery() {
        if (table_name == null)
            throw new NullPointerException("The table is null");

        return SYNTAX.replace("%table_name%", table_name)
                .replace("%conditional_expression%", whereClause != null ? whereClause.getClause() : "");
    }
}