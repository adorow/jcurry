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
public class CurryingLongToDoubleFunctionTest {

    @Test
    public void defaultFunctionalityIsNotAffected() {
        final long input = 5;
        final double expectedResult = 5;

        CurryingLongToDoubleFunction function = Currying.longToDoubleFunction(Functions::castToDouble);

        double result = function.applyAsDouble(input);
        assertThat(result, is(equalTo(expectedResult)));
    }

    @Test
    public void curry() {
        final long input = 5;
        final double expectedResult = 5;

        CurryingLongToDoubleFunction function = Currying.longToDoubleFunction(Functions::castToDouble);

        CurryingDoubleSupplier curried = function.curry(input);
        double result = curried.getAsDouble();
        assertThat(result, is(equalTo(expectedResult)));
    }

    @Test
    public void compose_function() {
        final String input = "5";
        final double expectedResult = 5;

        CurryingLongToDoubleFunction function = Currying.longToDoubleFunction(Functions::castToDouble);

        CurryingToDoubleFunction<String> compose = function.compose(str -> Long.parseLong(str));
        assertThat(compose.applyAsDouble(input), is(equalTo(expectedResult)));
    }

    @Test
    public void compose_biFunction() {
        final Integer inputA = 5;
        final Integer inputB = 6;
        final double expectedResult = 11;

        CurryingLongToDoubleFunction function = Currying.longToDoubleFunction(Functions::castToDouble);

        CurryingToDoubleBiFunction<Integer, Integer> compose = function.compose(BiFunctions::add);
        assertThat(compose.applyAsDouble(inputA, inputB), is(equalTo(expectedResult)));
    }

}
