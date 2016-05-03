package jcurry.util.function;

import jcurry.util.Currying;
import jcurry.util.function.testdata.LongBinaryOperators;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(JUnit4.class)
public class CurryingLongBinaryOperatorTest {

    @Test
    public void defaultFunctionalityIsNotAffected() {
        final long long1 = 50;
        final long long2 = 5;
        final long expectedResult = LongBinaryOperators.div(long1, long2);

        CurryingLongBinaryOperator binaryOperator = Currying.longBinaryOperator(LongBinaryOperators::div);

        long result = binaryOperator.applyAsLong(long1, long2);
        assertThat(result, is(equalTo(expectedResult)));
    }

    @Test
    public void curry_oneArg() {
        final long long1 = 50;
        final long long2 = 5;
        final long expectedResult = LongBinaryOperators.div(long1, long2);

        CurryingLongBinaryOperator binaryOperator = Currying.longBinaryOperator(LongBinaryOperators::div);

        CurryingLongUnaryOperator curried = binaryOperator.curry(long1);
        long result = curried.applyAsLong(long2);
        assertThat(result, is(equalTo(expectedResult)));
    }

    @Test
    public void curry_twoArgs() {
        final long long1 = 50;
        final long long2 = 5;
        final long expectedResult = LongBinaryOperators.div(long1, long2);

        CurryingLongBinaryOperator binaryOperator = Currying.longBinaryOperator(LongBinaryOperators::div);

        CurryingLongSupplier curried = binaryOperator.curry(long1, long2);
        long result = curried.getAsLong();
        assertThat(result, is(equalTo(expectedResult)));
    }

    @Test
    public void flip() {
        final long long1 = 50;
        final long long2 = 5;
        final long expectedResult = LongBinaryOperators.div(long1, long2);

        CurryingLongBinaryOperator binaryOperator = Currying.longBinaryOperator(LongBinaryOperators::div);

        CurryingLongBinaryOperator flipped = binaryOperator.flip();
        long result = flipped.applyAsLong(long2, long1);
        assertThat(result, is(equalTo(expectedResult)));
    }

}
