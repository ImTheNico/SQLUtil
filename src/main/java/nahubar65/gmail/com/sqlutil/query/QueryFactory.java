package nahubar65.gmail.com.sqlutil.query;

import nahubar65.gmail.com.sqlutil.query.abstraction.SQLQueryDelete;
import nahubar65.gmail.com.sqlutil.query.abstraction.SQLQueryInsert;
import nahubar65.gmail.com.sqlutil.query.abstraction.SQLQuerySelect;
import nahubar65.gmail.com.sqlutil.query.abstraction.SQLQueryUpdate;

public interface QueryFactory {

    static SQLQueryInsert newQueryInsert() {
        return new SQLQueryInsertImpl();
    }

    static SQLQueryUpdate newQueryUpdate() {
        return new SQLQueryUpdateImpl();
    }

    static SQLQueryDelete newQueryDelete() {
        return new SQLQueryDeleteImpl();
    }

    static SQLQuery newCustomQuery(String query) {
        return new CustomQuery(query);
    }

    static SQLQuerySelect newQuerySelect() {
        return new SQLQuerySelectImpl();
    }
}