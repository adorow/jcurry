package jcurry.util.function.testdata;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public final class Functions {

    private Functions() {}

    public static Integer binaryFromBoolean(Boolean b) {
        return b ? 1 : 0;
    }

    public static LocalDate addOneDay(LocalDate date) {
        return date.plusDays(1);
    }
}
