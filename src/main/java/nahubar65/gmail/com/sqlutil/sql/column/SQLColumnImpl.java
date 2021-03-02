package nahubar65.gmail.com.sqlutil.sql.column;

import nahubar65.gmail.com.sqlutil.sql.table.SQLTable;

public final class SQLColumnImpl implements SQLColumn {

    private final String name;

    private final String type;

    private final String className;

    private final SQLTable sqlTable;

    private final String catalogName;

    public SQLColumnImpl(String name, String type, String className, SQLTable sqlTable, String catalogName) {
        this.name = name;
        this.type = type;
        this.className = className;
        this.sqlTable = sqlTable;
        this.catalogName = catalogName;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String getClassName() {
        return className;
    }

    @Override
    public SQLTable getTable() {
        return sqlTable;
    }

    @Override
    public String getCatalogName() {
        return catalogName;
    }
}