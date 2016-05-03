package jcurry.util.function.testdata;

import java.time.LocalDate;
import java.util.function.Supplier;

public final class Suppliers {

    private Suppliers() {}

    public static LocalDate returnsToday() {
        return LocalDate.now();
    }

    public static <R> Supplier<R> supply(R r) {
        return () -> r;
    }
}
