package jcurry.util.function;

import jcurry.util.Currying;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(JUnit4.class)
public class CurryingDoubleFunctionTest {

    @Test
    public void defaultFunctionalityIsNotAffected() {
        final double input = 5;
        final String expectedResult = "5.0";

        CurryingDoubleFunction<String> function = Currying.doubleFunction(Double::toString);

        String result = function.apply(input);
        assertThat(result, is(equalTo(expectedResult)));
    }

    @Test
    public void curry() {
        final double input = 5.0;
        final String expectedResult = "5.0";

        CurryingDoubleFunction<String> function = Currying.doubleFunction(Double::toString);

        CurryingSupplier<String> curried = function.curry(input);
        String result = curried.get();
        assertThat(result, is(equalTo(expectedResult)));
    }

    @Test
    public void compose_function() {
        final Double a = 4.0;
        final String expectedResult = "5.0";

        CurryingDoubleFunction<String> function = Currying.doubleFunction(Double::toString);

        CurryingFunction<Double, String> compose = function.compose(v -> v + 1);
        assertThat(compose.apply(a), is(equalTo(expectedResult)));
    }
    
    @Test
    public void compose_biFunction() {
        final Double a = 4.0;
        final Double b = 1.0;
        final String expectedResult = "5.0";

        CurryingDoubleFunction<String> function = Currying.doubleFunction(Double::toString);

        CurryingBiFunction<Double, Double, String> compose = function.compose((v1, v2) -> v1 + v2);
        assertThat(compose.apply(a, b), is(equalTo(expectedResult)));
    }

}
