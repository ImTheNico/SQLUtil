package nahubar65.gmail.com.sqlutil.query.argument;

public class FieldQueryArgumentResolver implements QueryArgumentResolver {

    private final String[] fields;

    public FieldQueryArgumentResolver(String[] fields) {
         this.fields = fields;
    }

    @Override
    public String resolve() {
        StringBuilder builder = new StringBuilder();

        int count = fields.length;
        for (int i = 0; i < count; i++) {
            String column = fields[i];
            if (i > 0) {
                builder.append(",");
            }
            builder.append(column).append("=?");
        }

        return builder.toString();
    }
}