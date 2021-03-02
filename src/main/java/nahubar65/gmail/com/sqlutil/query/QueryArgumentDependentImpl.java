package nahubar65.gmail.com.sqlutil.query;

import nahubar65.gmail.com.sqlutil.statement.StatementValue;

import java.util.ArrayList;
import java.util.List;

abstract class QueryArgumentDependentImpl implements ArgumentDependent {

    private final List<StatementValue> arguments = new ArrayList<>();

    @Override
    public List<StatementValue> getArguments() {
        return arguments;
    }
}