package jcurry.util.function.testdata;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;

public final class DoubleConsumers {

    private DoubleConsumers() {}

    // consumes an input, and adds it to the accumulator
    public static DoubleConsumer consumerAddsToAccumulatorList(List<Double> accumulator) {
        return (t1) -> accumulator.add(t1);
    }

}
