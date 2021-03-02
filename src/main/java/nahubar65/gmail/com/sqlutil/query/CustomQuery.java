package nahubar65.gmail.com.sqlutil.query;

public class CustomQuery implements SQLQuery {

    private final String query;

    CustomQuery(String query) {
        this.query = query;
    }

    @Override
    public String getQuery() {
        return query;
    }
}