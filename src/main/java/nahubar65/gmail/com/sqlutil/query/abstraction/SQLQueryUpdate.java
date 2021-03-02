package nahubar65.gmail.com.sqlutil.query.abstraction;

import nahubar65.gmail.com.sqlutil.query.ArgumentDependent;
import nahubar65.gmail.com.sqlutil.query.clause.WhereClause;

public interface SQLQueryUpdate extends ArgumentDependent {

    SQLQueryUpdate setTable(String table);

    SQLQueryUpdate setWhereClause(WhereClause whereClause);

    SQLQueryUpdate addArgumentField(String... fields);

}