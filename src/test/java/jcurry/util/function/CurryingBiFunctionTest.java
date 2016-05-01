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
public class CurryingBiFunctionTest {

    @Test
    public void defaultFunctionalityIsNotAffected() {
        final String str1 = "foo";
        final Integer int1 = 5;
        final String expectedResult = str1 + int1;

        CurryingBiFunction<String, Integer, String> biFunction = Currying.biFunction(BiFunctions::concatenateStrAndInt);

        String result = biFunction.apply(str1, int1);
        assertThat(result, is(equalTo(expectedResult)));
    }

    @Test
    public void curry_oneArg() {
        final String str1 = "foo";
        final Integer int1 = 5;
        final String expectedResult = str1 + int1;

        CurryingBiFunction<String, Integer, String> biFunction = Currying.biFunction(BiFunctions::concatenateStrAndInt);

        CurryingFunction<Integer, String> curried = biFunction.curry(str1);
        String result = curried.apply(int1);
        assertThat(result, is(equalTo(expectedResult)));
    }

    @Test
    public void curry_twoArgs() {
        final String str1 = "foo";
        final Integer int1 = 5;
        final String expectedResult = str1 + int1;

        CurryingBiFunction<String, Integer, String> biFunction = Currying.biFunction(BiFunctions::concatenateStrAndInt);

        CurryingSupplier<String> curried = biFunction.curry(str1, int1);
        String result = curried.get();
        assertThat(result, is(equalTo(expectedResult)));
    }

    @Test
    public void flip() {
        final String str1 = "foo";
        final Integer int1 = 5;
        final String expectedResult = str1 + int1;

        CurryingBiFunction<String, Integer, String> biFunction = Currying.biFunction(BiFunctions::concatenateStrAndInt);

        CurryingBiFunction<Integer, String, String> flipped = biFunction.flip();
        String result = flipped.apply(int1, str1);
        assertThat(result, is(equalTo(expectedResult)));
    }

}
