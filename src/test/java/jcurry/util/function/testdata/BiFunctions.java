package jcurry.util.function.testdata;

import java.time.LocalDate;

public final class BiFunctions {

    private BiFunctions() {}

    // consumes two strings, and adds them to the accumulator
    public static String concatenateStrAndInt(String a, Integer b) {
        return a + b;
    }

    public static String concatenateBooleanAndStr(Boolean a, String b) {
        return a + b;
    }

    public static LocalDate addDays(LocalDate date, Integer numberOfDays) {
        return date.plusDays(numberOfDays);
    }

    public static Double divide(Double a, Double b) {
        return a / b;
    }

    public static Integer divide(Integer a, Integer b) {
        return a / b;
    }

    public static Long divide(Long a, Long b) {
        return a / b;
    }

    public static int add(Integer a, Integer b) {
        return a + b;
    }

    public static String concatStrings(String a, String b) {
        return a + b;
    }

}
