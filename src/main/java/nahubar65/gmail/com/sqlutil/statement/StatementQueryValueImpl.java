package nahubar65.gmail.com.sqlutil.statement;

public class StatementQueryValueImpl implements StatementValue {

    private final Integer index;

    private final Object value;

    public StatementQueryValueImpl(Integer index, Object value) {
        this.index = index;
        this.value = value;
    }

    @Override
    public Integer getIndex() {
        return index;
    }

    @Override
    public Object getValue() {
        return value;
    }
}