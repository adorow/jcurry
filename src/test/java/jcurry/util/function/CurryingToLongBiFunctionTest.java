package jcurry.util.function;

import jcurry.util.Currying;
import jcurry.util.function.testdata.ToLongBiFunctions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(JUnit4.class)
public class CurryingToLongBiFunctionTest {

    @Test
    public void defaultFunctionalityIsNotAffected() {
        final Long l1 = 10L;
        final Long l2 = 3L;
        final long expectedResult = ToLongBiFunctions.divide(l1, l2);

        CurryingToLongBiFunction<Long, Long> biFunction = Currying.toLongBiFunction(ToLongBiFunctions::divide);

        long result = biFunction.applyAsLong(l1, l2);
        assertThat(result, is(equalTo(expectedResult)));
    }

    @Test
    public void curry_oneArg() {
        final Long l1 = 10L;
        final Long l2 = 3L;
        final long expectedResult = ToLongBiFunctions.divide(l1, l2);

        CurryingToLongBiFunction<Long, Long> biFunction = Currying.toLongBiFunction(ToLongBiFunctions::divide);

        CurryingToLongFunction<Long> curried = biFunction.curry(l1);
        long result = curried.applyAsLong(l2);
        assertThat(result, is(equalTo(expectedResult)));
    }

    @Test
    public void curry_twoArgs() {
        final Long l1 = 10L;
        final Long l2 = 3L;
        final long expectedResult = ToLongBiFunctions.divide(l1, l2);

        CurryingToLongBiFunction<Long, Long> biFunction = Currying.toLongBiFunction(ToLongBiFunctions::divide);

        CurryingLongSupplier curried = biFunction.curry(l1, l2);
        long result = curried.getAsLong();
        assertThat(result, is(equalTo(expectedResult)));
    }

    @Test
    public void flip() {
        final Long l1 = 10L;
        final Long l2 = 3L;
        final long expectedResult = ToLongBiFunctions.divide(l1, l2);

        CurryingToLongBiFunction<Long, Long> biFunction = Currying.toLongBiFunction(ToLongBiFunctions::divide);

        CurryingToLongBiFunction<Long, Long> flipped = biFunction.flip();
        long result = flipped.applyAsLong(l2, l1);
        assertThat(result, is(equalTo(expectedResult)));
    }

}
