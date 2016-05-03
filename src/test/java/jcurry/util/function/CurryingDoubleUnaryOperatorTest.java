package jcurry.util.function;

import jcurry.util.Currying;
import jcurry.util.function.testdata.UnaryOperators;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(JUnit4.class)
public class CurryingDoubleUnaryOperatorTest {

    @Test
    public void defaultFunctionalityIsNotAffected() {
        final double v = 50;
        final double expectedResult = UnaryOperators.addOne(v);

        CurryingDoubleUnaryOperator unaryOperator = Currying.doubleUnaryOperator(UnaryOperators::addOne);

        double result = unaryOperator.applyAsDouble(v);
        assertThat(result, is(equalTo(expectedResult)));
    }

    @Test
    public void curry() {
        final double v = 50;
        final double expectedResult = UnaryOperators.addOne(v);

        CurryingDoubleUnaryOperator unaryOperator = Currying.doubleUnaryOperator(UnaryOperators::addOne);

        CurryingDoubleSupplier curried = unaryOperator.curry(v);
        double result = curried.getAsDouble();
        assertThat(result, is(equalTo(expectedResult)));
    }

}
