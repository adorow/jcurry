package jcurry.util.function;

import jcurry.util.Currying;
import jcurry.util.function.testdata.BiFunctions;
import jcurry.util.function.testdata.Functions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.time.LocalDate;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(JUnit4.class)
public class CurryingToIntFunctionTest {

    @Test
    public void defaultFunctionalityIsNotAffected() {
        final LocalDate input = LocalDate.of(2016, 5, 3);
        final int expectedResult = 16924;

        CurryingToIntFunction<LocalDate> function = Currying.toIntFunction(Functions::dateToInt);

        int result = function.applyAsInt(input);
        assertThat(result, is(equalTo(expectedResult)));
    }

    @Test
    public void curry() {
        final LocalDate input = LocalDate.of(2016, 5, 3);
        final int expectedResult = 16924;

        CurryingToIntFunction<LocalDate> function = Currying.toIntFunction(Functions::dateToInt);

        CurryingIntSupplier curried = function.curry(input);
        int result = curried.getAsInt();
        assertThat(result, is(equalTo(expectedResult)));
    }

    @Test
    public void compose_function() {
        final String input = "2016-05-03";
        final int expectedResult = 16924;

        CurryingToIntFunction<LocalDate> function = Currying.toIntFunction(Functions::dateToInt);

        CurryingToIntFunction<String> compose = function.compose(str -> LocalDate.parse(str));
        assertThat(compose.applyAsInt(input), is(equalTo(expectedResult)));
    }

    @Test
    public void compose_biFunction() {
        final LocalDate inputA = LocalDate.of(2016, 5, 2);
        final Integer inputB = 1;
        final int expectedResult = 16924;

        CurryingToIntFunction<LocalDate> function = Currying.toIntFunction(Functions::dateToInt);

        CurryingToIntBiFunction<LocalDate, Integer> compose = function.compose(BiFunctions::addDays);
        assertThat(compose.applyAsInt(inputA, inputB), is(equalTo(expectedResult)));
    }

}
