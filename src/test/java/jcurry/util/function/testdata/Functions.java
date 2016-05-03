package jcurry.util.function.testdata;

import java.time.LocalDate;

public final class Functions {

    private Functions() {}

    public static Integer binaryFromBoolean(Boolean b) {
        return b ? 1 : 0;
    }

    public static LocalDate addOneDay(LocalDate date) {
        return date.plusDays(1);
    }

    public static Double addsOne(Double v) {
        return v + 1;
    }

    public static Integer addsOne(Integer v) {
        return v + 1;
    }

    public static Long addsOne(Long v) {
        return v + 1;
    }

    public static <T> String toString(T t) {
        return String.valueOf(t);
    }
}
