package jcurry.util.function;

import jcurry.util.Currying;
import jcurry.util.function.testdata.BinaryOperators;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(JUnit4.class)
public class CurryingBinaryOperatorTest {

    @Test
    public void defaultFunctionalityIsNotAffected() {
        final Integer int1 = 50;
        final Integer int2 = 5;
        final Integer expectedResult = BinaryOperators.integerDiv(int1, int2);

        CurryingBinaryOperator<Integer> binaryOperator = Currying.binaryOperator(BinaryOperators::integerDiv);

        Integer result = binaryOperator.apply(int1, int2);
        assertThat(result, is(equalTo(expectedResult)));
    }

    @Test
    public void curry_oneArg() {
        final Integer int1 = 50;
        final Integer int2 = 5;
        final Integer expectedResult = BinaryOperators.integerDiv(int1, int2);

        CurryingBinaryOperator<Integer> binaryOperator = Currying.binaryOperator(BinaryOperators::integerDiv);

        CurryingUnaryOperator<Integer> curried = binaryOperator.curry(int1);
        Integer result = curried.apply(int2);
        assertThat(result, is(equalTo(expectedResult)));
    }

    @Test
    public void curry_twoArgs() {
        final Integer int1 = 50;
        final Integer int2 = 5;
        final Integer expectedResult = BinaryOperators.integerDiv(int1, int2);

        CurryingBinaryOperator<Integer> binaryOperator = Currying.binaryOperator(BinaryOperators::integerDiv);

        CurryingSupplier<Integer> curried = binaryOperator.curry(int1, int2);
        Integer result = curried.get();
        assertThat(result, is(equalTo(expectedResult)));
    }

    @Test
    public void flip() {
        final Integer int1 = 50;
        final Integer int2 = 5;
        final Integer expectedResult = BinaryOperators.integerDiv(int1, int2);

        CurryingBinaryOperator<Integer> binaryOperator = Currying.binaryOperator(BinaryOperators::integerDiv);

        CurryingBinaryOperator<Integer> flipped = binaryOperator.flip();
        Integer result = flipped.apply(int2, int1);
        assertThat(result, is(equalTo(expectedResult)));
    }

}
