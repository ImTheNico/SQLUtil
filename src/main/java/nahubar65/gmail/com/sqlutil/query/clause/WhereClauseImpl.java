package nahubar65.gmail.com.sqlutil.query.clause;

import nahubar65.gmail.com.sqlutil.utils.SQLUtils;

public class WhereClauseImpl implements WhereClause {

    private final String content;

    private boolean useBrackets;

    private static final String FORMAT = "WHERE %content%";

    public WhereClauseImpl(String content) {
        this.content = content;
    }

    @Override
    public WhereClause useBrackets(boolean b) {
        this.useBrackets = b;
        return this;
    }

    @Override
    public String getClause() {
        if (content == null)
            throw new NullPointerException("The content is null");

        return FORMAT.replace("%content%", useBrackets ? SQLUtils.insertBrackets(content) : content);
    }
}