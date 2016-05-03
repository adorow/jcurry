package jcurry.util.function;

import jcurry.util.Currying;
import jcurry.util.function.testdata.IntBinaryOperators;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(JUnit4.class)
public class CurryingIntBinaryOperatorTest {

    @Test
    public void defaultFunctionalityIsNotAffected() {
        final int int1 = 50;
        final int int2 = 5;
        final int expectedResult = IntBinaryOperators.div(int1, int2);

        CurryingIntBinaryOperator binaryOperator = Currying.intBinaryOperator(IntBinaryOperators::div);

        int result = binaryOperator.applyAsInt(int1, int2);
        assertThat(result, is(equalTo(expectedResult)));
    }

    @Test
    public void curry_oneArg() {
        final int int1 = 50;
        final int int2 = 5;
        final int expectedResult = IntBinaryOperators.div(int1, int2);

        CurryingIntBinaryOperator binaryOperator = Currying.intBinaryOperator(IntBinaryOperators::div);

        CurryingIntUnaryOperator curried = binaryOperator.curry(int1);
        int result = curried.applyAsInt(int2);
        assertThat(result, is(equalTo(expectedResult)));
    }

    @Test
    public void curry_twoArgs() {
        final int int1 = 50;
        final int int2 = 5;
        final int expectedResult = IntBinaryOperators.div(int1, int2);

        CurryingIntBinaryOperator binaryOperator = Currying.intBinaryOperator(IntBinaryOperators::div);

        CurryingIntSupplier curried = binaryOperator.curry(int1, int2);
        int result = curried.getAsInt();
        assertThat(result, is(equalTo(expectedResult)));
    }

    @Test
    public void flip() {
        final int int1 = 50;
        final int int2 = 5;
        final int expectedResult = IntBinaryOperators.div(int1, int2);

        CurryingIntBinaryOperator binaryOperator = Currying.intBinaryOperator(IntBinaryOperators::div);

        CurryingIntBinaryOperator flipped = binaryOperator.flip();
        int result = flipped.applyAsInt(int2, int1);
        assertThat(result, is(equalTo(expectedResult)));
    }

}
