package jcurry.util.function;

import jcurry.util.Currying;
import jcurry.util.function.testdata.DoubleBinaryOperators;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(JUnit4.class)
public class CurryingDoubleBinaryOperatorTest {

    @Test
    public void defaultFunctionalityIsNotAffected() {
        final double d1 = 50;
        final double d2 = 5;
        final double expectedResult = DoubleBinaryOperators.div(d1, d2);

        CurryingDoubleBinaryOperator binaryOperator = Currying.doubleBinaryOperator(DoubleBinaryOperators::div);

        double result = binaryOperator.applyAsDouble(d1, d2);
        assertThat(result, is(equalTo(expectedResult)));
    }

    @Test
    public void curry_oneArg() {
        final double d1 = 50;
        final double d2 = 5;
        final double expectedResult = DoubleBinaryOperators.div(d1, d2);

        CurryingDoubleBinaryOperator binaryOperator = Currying.doubleBinaryOperator(DoubleBinaryOperators::div);

        CurryingDoubleUnaryOperator curried = binaryOperator.curry(d1);
        double result = curried.applyAsDouble(d2);
        assertThat(result, is(equalTo(expectedResult)));
    }

    @Test
    public void curry_twoArgs() {
        final double d1 = 50;
        final double d2 = 5;
        final double expectedResult = DoubleBinaryOperators.div(d1, d2);

        CurryingDoubleBinaryOperator binaryOperator = Currying.doubleBinaryOperator(DoubleBinaryOperators::div);

        CurryingDoubleSupplier curried = binaryOperator.curry(d1, d2);
        double result = curried.getAsDouble();
        assertThat(result, is(equalTo(expectedResult)));
    }

    @Test
    public void flip() {
        final double d1 = 50;
        final double d2 = 5;
        final double expectedResult = DoubleBinaryOperators.div(d1, d2);

        CurryingDoubleBinaryOperator binaryOperator = Currying.doubleBinaryOperator(DoubleBinaryOperators::div);

        CurryingDoubleBinaryOperator flipped = binaryOperator.flip();
        double result = flipped.applyAsDouble(d2, d1);
        assertThat(result, is(equalTo(expectedResult)));
    }

}
