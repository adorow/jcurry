package jcurry.util.function.testdata;

public final class BiFunctions {

    private BiFunctions() {}

    // consumes two strings, and adds them to the accumulator
    public static String concatenateStrAndInt(String a, Integer b) {
        return a + b;
    }

}
