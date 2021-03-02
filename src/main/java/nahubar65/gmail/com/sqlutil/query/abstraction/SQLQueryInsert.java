package nahubar65.gmail.com.sqlutil.query.abstraction;

import nahubar65.gmail.com.sqlutil.query.ArgumentDependent;

public interface SQLQueryInsert extends ArgumentDependent {

    SQLQueryInsert setTable(String table);

}