/*
   Copyright 2016 Anderson Dorow

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */
package jcurry;

import jcurry.function.*;

import java.util.function.*;

/**
 * The entrypoint for decorating {@code java.util.function.*} interfaces into ramped-up types with the ability to curry.
 * <br/>
 * Currying means that you can partially apply parameters to functions. Passing for example one parameter to a two parameter function, effectively turning it into a one parameter function.
 * <br/>
 * Example:
 * <code>
 *     CurryingIntUnaryOperator upperBoundary10 = Curry.intBinaryOperator(Math::max).curry(10)
 * </code>
 *
 * @link https://en.wikipedia.org/wiki/Currying
 */
public final class Curry {

    private Curry() {}

    public static <T, U> CurryingBiConsumer<T, U> biConsumer(BiConsumer<T, U> consumer) {
        return (t, u) -> consumer.accept(t, u);
    }

    public static <T, U, R> CurryingBiFunction<T, U, R> biFunction(BiFunction<T, U, R> function) {
        return (t, u) -> function.apply(t, u);
    }

    public static <T> CurryingBinaryOperator<T> binaryOperator(BinaryOperator<T> operator) {
        return (t, t2) -> operator.apply(t, t2);
    }

    public static <T, U> CurryingBiPredicate<T, U> biPredicate(BiPredicate<T, U> predicate) {
        return (t, u) -> predicate.test(t, u);
    }

    public static CurryingBooleanSupplier booleanSupplier(BooleanSupplier supplier) {
        return () -> supplier.getAsBoolean();
    }

    public static <T> CurryingConsumer<T> consumer(Consumer<T> consumer) {
        return (t) -> consumer.accept(t);
    }

    public static CurryingDoubleBinaryOperator doubleBinaryOperator(DoubleBinaryOperator operator) {
        return (l, r) -> operator.applyAsDouble(l, r);
    }

    public static CurryingDoubleConsumer doubleConsumer(DoubleConsumer consumer) {
        return (d) -> consumer.accept(d);
    }

    public static <R> CurryingDoubleFunction<R> doubleFunction(DoubleFunction<R> function) {
        return (d) -> function.apply(d);
    }

    public static CurryingDoublePredicate doublePredicate(DoublePredicate predicate) {
        return (d) -> predicate.test(d);
    }

    public static CurryingDoubleSupplier doubleSupplier(DoubleSupplier supplier) {
        return () -> supplier.getAsDouble();
    }

    public static CurryingDoubleToIntFunction doubleToIntFunction(DoubleToIntFunction function) {
        return (d) -> function.applyAsInt(d);
    }

    public static CurryingDoubleToLongFunction doubleToLongFunction(DoubleToLongFunction function) {
        return (d) -> function.applyAsLong(d);
    }

    public static CurryingDoubleUnaryOperator doubleUnaryOperator(DoubleUnaryOperator operator) {
        return (d) -> operator.applyAsDouble(d);
    }

    public static <T, R> CurryingFunction<T, R> function(Function<T, R> function) {
        return (t) -> function.apply(t);
    }

    public static CurryingIntBinaryOperator intBinaryOperator(IntBinaryOperator operator) {
        return (l, r) -> operator.applyAsInt(l, r);
    }

    public static CurryingIntConsumer intConsumer(IntConsumer consumer) {
        return (i) -> consumer.accept(i);
    }

    public static <R> CurryingIntFunction<R> intFunction(IntFunction<R> function) {
        return (t) -> function.apply(t);
    }

    public static CurryingIntPredicate intPredicate(IntPredicate predicate) {
        return (i) -> predicate.test(i);
    }

    public static CurryingIntSupplier intSupplier(IntSupplier supplier) {
        return () -> supplier.getAsInt();
    }

    public static CurryingIntToDoubleFunction intToDoubleFunction(IntToDoubleFunction function) {
        return (i) -> function.applyAsDouble(i);
    }

    public static CurryingIntToLongFunction intToLongFunction(IntToLongFunction function) {
        return (i) -> function.applyAsLong(i);
    }

    public static CurryingIntUnaryOperator intUnaryOperator(IntUnaryOperator operator) {
        return (i) -> operator.applyAsInt(i);
    }

    public static CurryingLongBinaryOperator longBinaryOperator(LongBinaryOperator operator) {
        return (l, r) -> operator.applyAsLong(l, r);
    }

    public static CurryingLongConsumer longConsumer(LongConsumer consumer) {
        return (d) -> consumer.accept(d);
    }

    public static <R> CurryingLongFunction<R> longFunction(LongFunction<R> function) {
        return (d) -> function.apply(d);
    }

    public static CurryingLongPredicate longPredicate(LongPredicate predicate) {
        return (d) -> predicate.test(d);
    }

    public static CurryingLongSupplier longSupplier(LongSupplier supplier) {
        return () -> supplier.getAsLong();
    }

    public static CurryingLongToDoubleFunction longToDoubleFunction(LongToDoubleFunction function) {
        return (i) -> function.applyAsDouble(i);
    }

    public static CurryingLongToIntFunction longToIntFunction(LongToIntFunction function) {
        return (i) -> function.applyAsInt(i);
    }

    public static CurryingLongUnaryOperator longUnaryOperator(LongUnaryOperator operator) {
        return (l) -> operator.applyAsLong(l);
    }

    public static <T> CurryingObjDoubleConsumer<T> objDoubleConsumer(ObjDoubleConsumer consumer) {
        return (t, d) -> consumer.accept(t, d);
    }

    public static <T> CurryingObjIntConsumer<T> objIntConsumer(ObjIntConsumer consumer) {
        return (t, i) -> consumer.accept(t, i);
    }

    public static <T> CurryingObjLongConsumer<T> objLongConsumer(ObjLongConsumer consumer) {
        return (t, l) -> consumer.accept(t, l);
    }

    public static <T> CurryingPredicate<T> predicate(Predicate<T> predicate) {
        return (t) -> predicate.test(t);
    }

    public static <T> CurryingSupplier<T> supplier(Supplier<T> supplier) {
        return () -> supplier.get();
    }

    public static <T, U> CurryingToDoubleBiFunction<T, U> toDoubleBiFunction(ToDoubleBiFunction<T, U> function) {
        return (t, u) -> function.applyAsDouble(t, u);
    }

    public static <T> CurryingToDoubleFunction<T> toDoubleFunction(ToDoubleFunction<T> function) {
        return (t) -> function.applyAsDouble(t);
    }

    public static <T, U> CurryingToIntBiFunction<T, U> toIntBiFunction(ToIntBiFunction<T, U> function) {
        return (t, u) -> function.applyAsInt(t, u);
    }

    public static <T> CurryingToIntFunction<T> toIntFunction(ToIntFunction<T> function) {
        return (t) -> function.applyAsInt(t);
    }

    public static <T, U> CurryingToLongBiFunction<T, U> toLongBiFunction(ToLongBiFunction<T, U> function) {
        return (t, u) -> function.applyAsLong(t, u);
    }

    public static <T> CurryingToLongFunction<T> toLongFunction(ToLongFunction<T> function) {
        return (t) -> function.applyAsLong(t);
    }

    public static <T> CurryingUnaryOperator<T> unaryOperator(UnaryOperator<T> operator) {
        return (t) -> operator.apply(t);
    }

}
