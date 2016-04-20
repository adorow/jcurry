package jcurry.function;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public interface CurryingSupplier<T> extends Supplier<T> {

    default <R> CurryingSupplier<R> andThen(Function<? super T, ? extends R> after) {
        return () -> after.apply(this.get());
    }

    default <U, R> CurryingFunction<U, R> andThenComposeInto(BiFunction<? super T, ? super U, ? extends R> after) {
        return (u) -> after.apply(this.get(), u);
    }

}
