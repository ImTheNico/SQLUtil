package nahubar65.gmail.com.sqlutil.utils;

public interface SQLUtils {

    static String protectTable(String table) {
        return "`" + table + "`";
    }

    static String insertBrackets(String string) {
        return "(" + string + ")";
    }
}