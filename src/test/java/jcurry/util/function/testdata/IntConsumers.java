package jcurry.util.function.testdata;

import java.util.List;
import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;

public final class IntConsumers {

    private IntConsumers() {}

    // consumes an input, and adds it to the accumulator
    public static IntConsumer consumerAddsToAccumulatorList(List<Integer> accumulator) {
        return (t1) -> accumulator.add(t1);
    }

}
