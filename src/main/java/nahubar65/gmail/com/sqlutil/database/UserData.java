package nahubar65.gmail.com.sqlutil.database;

public interface UserData {

    String JDBC_URL = "jdbc:mysql://<ip>:<port>/<database>";

    String getPassword();

    String getUsername();

    String getIp();

    String getPort();

    String getDatabase();

    String getJdbcURL();

    UserData useCustomJdbcURL(String jdbcUrl);

    Object getHikariDataSource() throws NoClassDefFoundError;
}