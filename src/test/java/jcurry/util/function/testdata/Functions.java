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

    public static int castToInt(double v) {
        return (int) v;
    }

    public static int castToInt(long v) {
        return (int) v;
    }

    public static long castToLong(double v) {
        return (long) v;
    }

    public static long castToLong(int v) {
        return v;
    }

    public static double castToDouble(long v) {
        return v;
    }

    public static double castToDouble(int v) {
        return v;
    }

    public static double dateToDouble(LocalDate date) {
        return date.toEpochDay();
    }

    public static long dateToLong(LocalDate date) {
        return date.toEpochDay();
    }

    public static int dateToInt(LocalDate date) {
        return (int) date.toEpochDay();
    }

}
