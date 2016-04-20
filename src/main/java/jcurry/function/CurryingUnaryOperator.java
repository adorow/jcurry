package jcurry.function;

import java.util.function.UnaryOperator;

public interface CurryingUnaryOperator<T> extends UnaryOperator<T>, CurryingFunction<T, T> {

}
