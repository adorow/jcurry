package jcurry.util.function.testdata;

public final class Predicates {

    private Predicates() {}

    public static boolean isZero(int i) {
        return i == 0;
    }

    public static boolean isZero(long lo) {
        return lo == 0;
    }

    public static boolean isZero(double v) {
        return v == 0;
    }
}
