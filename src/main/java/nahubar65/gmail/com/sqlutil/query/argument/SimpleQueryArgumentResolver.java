package nahubar65.gmail.com.sqlutil.query.argument;

public class SimpleQueryArgumentResolver implements QueryArgumentResolver {

    private final int count;

    public SimpleQueryArgumentResolver(int count) {
        this.count = count;
    }

    @Override
    public String resolve() {
        StringBuilder query = new StringBuilder();

        for (int i = 0; i < count; i++) {
            if (i > 0) {
                query.append(",");
            }
            query.append("?");
        }

        return query.toString();
    }
}