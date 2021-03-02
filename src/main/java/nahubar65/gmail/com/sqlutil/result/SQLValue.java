package nahubar65.gmail.com.sqlutil.result;

import java.util.Objects;

public interface SQLValue {

    Object get();

    default String getString() {
        return Objects.toString(get());
    }

    default int getInt() {
        Object o = get();
        if (o instanceof Number) {
            Number number = (Number) o;
            return number.intValue();
        } else {
            throw new ClassCastException(o.getClass().getSimpleName() + " cannot cast to int");
        }
    }

    default double getDouble() {
        Object o = get();
        if (o instanceof Number) {
            Number number = (Number) o;
            return number.doubleValue();
        } else {
            throw new ClassCastException(o.getClass().getSimpleName() + " cannot cast to double");
        }
    }

    default byte getByte() {
        Object o = get();
        if (o instanceof Number) {
            Number number = (Number) o;
            return number.byteValue();
        } else {
            throw new ClassCastException(o.getClass().getSimpleName() + " cannot cast to byte");
        }
    }

    default byte[] getByteArray() {
        Object o = get();
        if (o instanceof byte[]) {
            return (byte[]) o;
        }
        return null;
    }

    default float getFloat() {
        Object o = get();
        if (o instanceof Number) {
            Number number = (Number) o;
            return number.floatValue();
        } else {
            throw new ClassCastException(o.getClass().getSimpleName() + " cannot cast to float");
        }
    }

    default boolean getBoolean() {
        Object o = get();
        return o instanceof Boolean ? (Boolean) o : false;
    }
}