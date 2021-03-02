package nahubar65.gmail.com.sqlutil.query.abstraction;

import nahubar65.gmail.com.sqlutil.query.SQLQuery;
import nahubar65.gmail.com.sqlutil.query.clause.WhereClause;

public interface SQLQuerySelect extends SQLQuery {

    SQLQuerySelect addField(String... values);

    SQLQuerySelect setTable(String table);

    SQLQuerySelect setWhereClause(WhereClause whereClause);
}