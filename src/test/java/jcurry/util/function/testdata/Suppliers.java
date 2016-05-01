package jcurry.util.function.testdata;

import java.time.LocalDate;

public final class Suppliers {

    private Suppliers() {}

    public static LocalDate returnsToday() {
        return LocalDate.now();
    }
}
