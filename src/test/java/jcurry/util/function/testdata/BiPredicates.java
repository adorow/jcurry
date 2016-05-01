package jcurry.util.function.testdata;

public final class BiPredicates {

    private BiPredicates() {}

    public static boolean isFirstElementSmallerThan5(Integer a, Long b) {
        return a < 5;
    }

}
