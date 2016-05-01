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
}
