package nahubar65.gmail.com.sqlutil.result;

public class DefaultSQLValue implements SQLValue {

    private final Object object;

    public DefaultSQLValue(Object object) {
        this.object = object;
    }

    @Override
    public Object get() {
        return object;
    }
}