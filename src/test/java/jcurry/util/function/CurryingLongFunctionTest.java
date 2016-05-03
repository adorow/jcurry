package jcurry.util.function;

import jcurry.util.Currying;
import jcurry.util.function.testdata.BiFunctions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(JUnit4.class)
public class CurryingLongFunctionTest {

    @Test
    public void defaultFunctionalityIsNotAffected() {
        final long input = 5;
        final String expectedResult = "101";

        CurryingLongFunction<String> function = Currying.longFunction(Long::toBinaryString);

        String result = function.apply(input);
        assertThat(result, is(equalTo(expectedResult)));
    }

    @Test
    public void curry() {
        final long input = 5;
        final String expectedResult = "101";

        CurryingLongFunction<String> function = Currying.longFunction(Long::toBinaryString);

        CurryingSupplier<String> curried = function.curry(input);
        String result = curried.get();
        assertThat(result, is(equalTo(expectedResult)));
    }

    @Test
    public void compose_function() {
        final Long a = 4L;
        final String expectedResult = "101";

        CurryingLongFunction<String> function = Currying.longFunction(Long::toBinaryString);

        CurryingFunction<Long, String> compose = function.compose(v -> v + 1);
        assertThat(compose.apply(a), is(equalTo(expectedResult)));
    }
    
    @Test
    public void compose_biFunction() {
        final Long a = 4L;
        final Long b = 1L;
        final String expectedResult = "101";

        CurryingLongFunction<String> function = Currying.longFunction(Long::toBinaryString);

        CurryingBiFunction<Long, Long, String> compose = function.compose((v1, v2) -> v1 + v2);
        assertThat(compose.apply(a, b), is(equalTo(expectedResult)));
    }

}
