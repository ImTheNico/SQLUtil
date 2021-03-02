package nahubar65.gmail.com.sqlutil.database;

import com.zaxxer.hikari.HikariDataSource;

public class UserDataImpl implements UserData {

    private final String password;

    private final String username;

    private final String ip;

    private final String port;

    private final String database;

    private String jdbcUrl;

    public UserDataImpl(String password, String username, String ip, String port, String database, String jdbcUrl) {
        this.password = password;
        this.username = username;
        this.ip = ip;
        this.port = port;
        this.database = database;
        this.jdbcUrl = jdbcUrl;
    }

    public UserDataImpl(String password, String username, String ip, String port, String database) {
        this(password, username, ip, port, database, null);
    }

    public UserDataImpl(String password, String username, String ip, String database) {
        this(password, username, ip, "3306", database);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getIp() {
        return ip;
    }

    @Override
    public String getPort() {
        return port;
    }

    @Override
    public String getDatabase() {
        return database;
    }

    @Override
    public String getJdbcURL() {
        return jdbcUrl != null ? insertProperties(jdbcUrl) : insertProperties(JDBC_URL);
    }

    @Override
    public UserData useCustomJdbcURL(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
        return this;
    }

    @Override
    public Object getHikariDataSource() throws NoClassDefFoundError {
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setJdbcUrl(getJdbcURL());
        hikariDataSource.setUsername(username);
        hikariDataSource.setPassword(password);
        return hikariDataSource;
    }

    private String insertProperties(String string) {
        return string.replace("<ip>", ip).replace("<port>", port).replace("<database>", database);
    }
}