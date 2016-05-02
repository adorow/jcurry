package jcurry.util.function.testdata;

import java.util.List;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;

public final class LongConsumers {

    private LongConsumers() {}

    // consumes an input, and adds it to the accumulator
    public static LongConsumer consumerAddsToAccumulatorList(List<Long> accumulator) {
        return (t1) -> accumulator.add(t1);
    }

}
