package jcurry.function;

import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Function;

public interface CurryingFunction<T, R> extends Function<T, R> {

    default CurryingSupplier<R> curry(T t) {
        return () -> this.apply(t);
    }

    default <V, U> CurryingBiFunction<V, U, R> compose(BiFunction<? super V, ? super U, ? extends T> before) {
        Objects.requireNonNull(before);
        return (v, u) -> this.apply(before.apply(v, u));
    }

}
