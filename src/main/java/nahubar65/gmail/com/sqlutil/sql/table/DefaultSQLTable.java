package nahubar65.gmail.com.sqlutil.sql.table;

import java.sql.Connection;

public final class DefaultSQLTable implements SQLTable {

    private final String identifier;

    private final Connection connection;

    public DefaultSQLTable(String identifier, Connection connection) {
        this.identifier = identifier;
        this.connection = connection;
    }

    @Override
    public String getIdentifier() {
        return identifier;
    }

    @Override
    public SQLTableData getData() {
        return new DefaultSQLTableData(this, connection);
    }

    @Override
    public Connection getConnection() {
        return connection;
    }
}