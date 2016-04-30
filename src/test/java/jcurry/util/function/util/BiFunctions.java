package jcurry.util.function.util;

/**
 * Test utility class containing sample BiFunction functions.
 */
public class BiFunctions {

    private BiFunctions() {}

    // consumes two strings, and adds them to the accumulator
    public static String concatenateStrAndInt(String a, Integer b) {
        return a + b;
    }

}
