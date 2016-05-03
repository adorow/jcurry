package jcurry.util.function;

import jcurry.util.Currying;
import jcurry.util.function.testdata.BiFunctions;
import jcurry.util.function.testdata.Functions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(JUnit4.class)
public class CurryingDoubleToLongFunctionTest {

    @Test
    public void defaultFunctionalityIsNotAffected() {
        final double input = 5;
        final long expectedResult = 5;

        CurryingDoubleToLongFunction function = Currying.doubleToLongFunction(Functions::castToLong);

        long result = function.applyAsLong(input);
        assertThat(result, is(equalTo(expectedResult)));
    }

    @Test
    public void curry() {
        final double input = 5;
        final long expectedResult = 5;

        CurryingDoubleToLongFunction function = Currying.doubleToLongFunction(Functions::castToLong);

        CurryingLongSupplier curried = function.curry(input);
        long result = curried.getAsLong();
        assertThat(result, is(equalTo(expectedResult)));
    }

    @Test
    public void compose_function() {
        final String input = "5";
        final long expectedResult = 5;

        CurryingDoubleToLongFunction function = Currying.doubleToLongFunction(Functions::castToLong);

        CurryingToLongFunction<String> compose = function.compose(str -> Long.parseLong(str));
        assertThat(compose.applyAsLong(input), is(equalTo(expectedResult)));
    }

    @Test
    public void compose_biFunction() {
        final Integer inputA = 5;
        final Integer inputB = 6;
        final long expectedResult = 11;

        CurryingDoubleToLongFunction function = Currying.doubleToLongFunction(Functions::castToLong);

        CurryingToLongBiFunction<Integer, Integer> compose = function.compose(BiFunctions::add);
        assertThat(compose.applyAsLong(inputA, inputB), is(equalTo(expectedResult)));
    }

}
