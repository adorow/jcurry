package jcurry.function;

import java.util.function.BiFunction;

public interface CurryingBiFunction<T, U, R> extends BiFunction<T, U, R> {

    default CurryingFunction<U, R> curry(T t) {
        return (u) -> this.apply(t, u);
    }

    default CurryingSupplier<R> curry(T t, U u) {
        return () -> this.apply(t, u);
    }

    default CurryingBiFunction<U, T, R> flip() {
        return (u, t) -> this.apply(t, u);
    }

}
