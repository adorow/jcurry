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
public class CurryingFunctionTest {

    @Test
    public void defaultFunctionalityIsNotAffected() {
        final Integer input = 5;
        final String expectedResult = "5";

        CurryingFunction<Integer, String> function = Currying.function(Functions::toString);

        String result = function.apply(input);
        assertThat(result, is(equalTo(expectedResult)));
    }

    @Test
    public void curry() {
        final Integer input = 5;
        final String expectedResult = "5";
        CurryingFunction<Integer, String> function = Currying.function(Functions::toString);

        CurryingSupplier<String> curried = function.curry(input);
        String result = curried.get();
        assertThat(result, is(equalTo(expectedResult)));
    }

    @Test
    public void compose_biFunction() {
        final String a = "5";
        final String b = "1";
        final Integer expectedResult = 51;

        CurryingFunction<String, Integer> function = Currying.function(Integer::valueOf);

        CurryingBiFunction<String, String, Integer> compose = function.compose(BiFunctions::concatStrings);
        assertThat(compose.apply(a, b), is(equalTo(expectedResult)));
    }

}
