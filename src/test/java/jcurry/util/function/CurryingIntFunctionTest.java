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
public class CurryingIntFunctionTest {

    @Test
    public void defaultFunctionalityIsNotAffected() {
        final int input = 5;
        final String expectedResult = "101";

        CurryingIntFunction<String> function = Currying.intFunction(Integer::toBinaryString);

        String result = function.apply(input);
        assertThat(result, is(equalTo(expectedResult)));
    }

    @Test
    public void curry() {
        final int input = 5;
        final String expectedResult = "101";

        CurryingIntFunction<String> function = Currying.intFunction(Integer::toBinaryString);

        CurryingSupplier<String> curried = function.curry(input);
        String result = curried.get();
        assertThat(result, is(equalTo(expectedResult)));
    }

    @Test
    public void compose_function() {
        final Integer a = 4;
        final String expectedResult = "101";

        CurryingIntFunction<String> function = Currying.intFunction(Integer::toBinaryString);

        CurryingFunction<Integer, String> compose = function.compose(v -> v + 1);
        assertThat(compose.apply(a), is(equalTo(expectedResult)));
    }
    
    @Test
    public void compose_biFunction() {
        final Integer a = 4;
        final Integer b = 1;
        final String expectedResult = "101";

        CurryingIntFunction<String> function = Currying.intFunction(Integer::toBinaryString);

        CurryingBiFunction<Integer, Integer, String> compose = function.compose(BiFunctions::add);
        assertThat(compose.apply(a, b), is(equalTo(expectedResult)));
    }

}
