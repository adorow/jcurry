package jcurry;

import jcurry.function.*;

import java.util.function.*;

public final class Curry {

    private Curry() {}

    public static <T, U> CurryingBiConsumer<T, U> as(BiConsumer<T, U> consumer) {
        return (t, u) -> consumer.accept(t, u);
    }

    public static <T, U, R> CurryingBiFunction<T, U, R> as(BiFunction<T, U, R> function) {
        return (t, u) -> function.apply(t, u);
    }

    public static <T> CurryingBinaryOperator<T> as(BinaryOperator<T> operator) {
        return (t, t2) -> operator.apply(t, t2);
    }
    public static <T, U> CurryingBiPredicate<T, U> as(BiPredicate<T, U> predicate) {
        return (t, u) -> predicate.test(t, u);
    }

    public static CurryingBooleanSupplier as(BooleanSupplier supplier) {
        return () -> supplier.getAsBoolean();
    }

    public static <T> CurryingConsumer<T> as(Consumer<T> consumer) {
        return (t) -> consumer.accept(t);
    }

    public static CurryingDoubleBinaryOperator as(DoubleBinaryOperator operator) {
        return (l, r) -> operator.applyAsDouble(l, r);
    }

    public static CurryingDoubleConsumer as(DoubleConsumer consumer) {
        return (d) -> consumer.accept(d);
    }

    public static <R> CurryingDoubleFunction<R> as(DoubleFunction<R> function) {
        return (d) -> function.apply(d);
    }

    public static CurryingDoublePredicate as(DoublePredicate predicate) {
        return (d) -> predicate.test(d);
    }

    public static CurryingDoubleSupplier as(DoubleSupplier supplier) {
        return () -> supplier.getAsDouble();
    }

    public static CurryingDoubleToIntFunction as(DoubleToIntFunction function) {
        return (d) -> function.applyAsInt(d);
    }

    public static CurryingDoubleToLongFunction as(DoubleToLongFunction function) {
        return (d) -> function.applyAsLong(d);
    }

    public static CurryingDoubleUnaryOperator as(DoubleUnaryOperator operator) {
        return (d) -> operator.applyAsDouble(d);
    }

    public static <T, R> CurryingFunction<T, R> as(Function<T, R> function) {
        return (t) -> function.apply(t);
    }

    public static CurryingIntBinaryOperator as(IntBinaryOperator operator) {
        return (l, r) -> operator.applyAsInt(l, r);
    }

    public static CurryingIntConsumer as(IntConsumer consumer) {
        return (i) -> consumer.accept(i);
    }

    public static <R> CurryingIntFunction<R> as(IntFunction<R> function) {
        return (t) -> function.apply(t);
    }

    public static CurryingIntPredicate as(IntPredicate predicate) {
        return (i) -> predicate.test(i);
    }

    public static CurryingIntSupplier as(IntSupplier supplier) {
        return () -> supplier.getAsInt();
    }

    public static CurryingIntToDoubleFunction as(IntToDoubleFunction function) {
        return (i) -> function.applyAsDouble(i);
    }

    public static CurryingIntToLongFunction as(IntToLongFunction function) {
        return (i) -> function.applyAsLong(i);
    }

    public static CurryingIntUnaryOperator as(IntUnaryOperator operator) {
        return (i) -> operator.applyAsInt(i);
    }

    public static CurryingLongBinaryOperator as(LongBinaryOperator operator) {
        return (l, r) -> operator.applyAsLong(l, r);
    }

    public static CurryingLongConsumer as(LongConsumer consumer) {
        return (d) -> consumer.accept(d);
    }

    public static <R> CurryingLongFunction<R> as(LongFunction<R> function) {
        return (d) -> function.apply(d);
    }

    public static CurryingLongPredicate as(LongPredicate predicate) {
        return (d) -> predicate.test(d);
    }

    public static CurryingLongSupplier as(LongSupplier supplier) {
        return () -> supplier.getAsLong();
    }

    public static CurryingLongToDoubleFunction as(LongToDoubleFunction function) {
        return (i) -> function.applyAsDouble(i);
    }

    public static CurryingLongToIntFunction as(LongToIntFunction function) {
        return (i) -> function.applyAsInt(i);
    }

    public static CurryingLongUnaryOperator as(LongUnaryOperator operator) {
        return (l) -> operator.applyAsLong(l);
    }

    public static <T> CurryingObjDoubleConsumer<T> as(ObjDoubleConsumer consumer) {
        return (t, d) -> consumer.accept(t, d);
    }

    public static <T> CurryingObjIntConsumer<T> as(ObjIntConsumer consumer) {
        return (t, i) -> consumer.accept(t, i);
    }

    public static <T> CurryingObjLongConsumer<T> as(ObjLongConsumer consumer) {
        return (t, l) -> consumer.accept(t, l);
    }

    public static <T> CurryingPredicate<T> as(Predicate<T> predicate) {
        return (t) -> predicate.test(t);
    }

    public static <T> CurryingSupplier<T> as(Supplier<T> supplier) {
        return () -> supplier.get();
    }

    public static <T, U> CurryingToDoubleBiFunction<T, U> as(ToDoubleBiFunction<T, U> function) {
        return (t, u) -> function.applyAsDouble(t, u);
    }

    public static <T> CurryingToDoubleFunction<T> as(ToDoubleFunction<T> function) {
        return (t) -> function.applyAsDouble(t);
    }

    public static <T, U> CurryingToIntBiFunction<T, U> as(ToIntBiFunction<T, U> function) {
        return (t, u) -> function.applyAsInt(t, u);
    }

    public static <T> CurryingToIntFunction<T> as(ToIntFunction<T> function) {
        return (t) -> function.applyAsInt(t);
    }

    public static <T, U> CurryingToLongBiFunction<T, U> as(ToLongBiFunction<T, U> function) {
        return (t, u) -> function.applyAsLong(t, u);
    }

    public static <T> CurryingToLongFunction<T> as(ToLongFunction<T> function) {
        return (t) -> function.applyAsLong(t);
    }

    public static <T> CurryingUnaryOperator<T> as(UnaryOperator<T> operator) {
        return (t) -> operator.apply(t);
    }

}
