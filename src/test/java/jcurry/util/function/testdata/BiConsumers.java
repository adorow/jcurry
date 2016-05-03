package jcurry.util.function.testdata;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.ObjDoubleConsumer;
import java.util.function.ObjIntConsumer;
import java.util.function.ObjLongConsumer;

public final class BiConsumers {

    private BiConsumers() {}

    // consumes two strings, and adds them to the accumulator
    public static <T, U> BiConsumer<T, U> biConsumerAddsToAccumulatorList(List<Object> accumulator) {
        return (t1, t2) -> { accumulator.add(t1); accumulator.add(t2); };
    }

    public static <T> ObjDoubleConsumer<T> objDoubleConsumerAddsToAccumulatorList(List<Object> accumulator) {
        return (t1, t2) -> { accumulator.add(t1); accumulator.add(t2); };
    }

    public static <T> ObjIntConsumer<T> objIntConsumerAddsToAccumulatorList(List<Object> accumulator) {
        return (t1, t2) -> { accumulator.add(t1); accumulator.add(t2); };
    }

    public static <T> ObjLongConsumer<T> objLongConsumerAddsToAccumulatorList(List<Object> accumulator) {
        return (t1, t2) -> { accumulator.add(t1); accumulator.add(t2); };
    }

}
