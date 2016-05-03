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
public class CurryingDoubleToIntFunctionTest {

    @Test
    public void defaultFunctionalityIsNotAffected() {
        final double input = 5;
        final int expectedResult = 5;

        CurryingDoubleToIntFunction function = Currying.doubleToIntFunction(Functions::castToInt);

        int result = function.applyAsInt(input);
        assertThat(result, is(equalTo(expectedResult)));
    }

    @Test
    public void curry() {
        final double input = 5;
        final int expectedResult = 5;

        CurryingDoubleToIntFunction function = Currying.doubleToIntFunction(Functions::castToInt);

        CurryingIntSupplier curried = function.curry(input);
        int result = curried.getAsInt();
        assertThat(result, is(equalTo(expectedResult)));
    }

    @Test
    public void compose_function() {
        final String input = "5";
        final int expectedResult = 5;

        CurryingDoubleToIntFunction function = Currying.doubleToIntFunction(Functions::castToInt);

        CurryingToIntFunction<String> compose = function.compose(str -> Integer.parseInt(str));
        assertThat(compose.applyAsInt(input), is(equalTo(expectedResult)));
    }

    @Test
    public void compose_biFunction() {
        final Integer inputA = 5;
        final Integer inputB = 6;
        final int expectedResult = 11;

        CurryingDoubleToIntFunction function = Currying.doubleToIntFunction(Functions::castToInt);

        CurryingToIntBiFunction<Integer, Integer> compose = function.compose(BiFunctions::add);
        assertThat(compose.applyAsInt(inputA, inputB), is(equalTo(expectedResult)));
    }

}
