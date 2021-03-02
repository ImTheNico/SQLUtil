package nahubar65.gmail.com.sqlutil.result;

import java.util.Map;

public final class SimpleResultImpl implements Result {

    private final Map<String, SQLValue> sqlValueMap;

    public SimpleResultImpl(Map<String, SQLValue> sqlValueMap) {
        this.sqlValueMap = sqlValueMap;
    }

    @Override
    public Map<String, SQLValue> getValues() {
        return sqlValueMap;
    }
}