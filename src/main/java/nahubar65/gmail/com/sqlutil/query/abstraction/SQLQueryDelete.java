package nahubar65.gmail.com.sqlutil.query.abstraction;

import nahubar65.gmail.com.sqlutil.query.SQLQuery;
import nahubar65.gmail.com.sqlutil.query.clause.WhereClause;

public interface SQLQueryDelete extends SQLQuery {

    SQLQueryDelete setTable(String table);

    SQLQueryDelete setWhereClause(WhereClause whereClause);

}