package nahubar65.gmail.com.sqlutil.result;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

public interface Result {

    Map<String, SQLValue> getValues();

    static Result getResult(ResultSet resultSet) throws SQLException {
        Result result = null;
        Map<String, SQLValue> sqlValueMap = new LinkedHashMap<>();
        if (resultSet != null) {
            while (resultSet.next()) {
                for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
                    Object o = resultSet.getObject(i);
                    sqlValueMap.put(resultSet.getMetaData().getColumnLabel(i), new DefaultSQLValue(o));
                }
            }
            result = new SimpleResultImpl(sqlValueMap);
        }
        return result;
    }
}