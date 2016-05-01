package jcurry.util.function.util;

import java.util.List;
import java.util.function.BiConsumer;

/**
 * Test utility class containing sample BiConsumer functions.
 */
public final class BiConsumers {

    private BiConsumers() {}

    // consumes two strings, and adds them to the accumulator
    public static <T, U> BiConsumer<T, U> biConsumerAddsToAccumulatorList(List<Object> accumulator) {
        return (t1, t2) -> { accumulator.add(t1); accumulator.add(t2); };
    }

}
