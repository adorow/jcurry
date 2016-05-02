package jcurry.util.function.testdata;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public final class Consumers {

    private Consumers() {}

    // consumes a string, and adds it to the accumulator
    public static <T> Consumer<T> consumerAddsToAccumulatorList(List<Object> accumulator) {
        return (t1) -> accumulator.add(t1);
    }

}
