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
public class CurryingToLongFunctionTest {

    @Test
    public void defaultFunctionalityIsNotAffected() {
        final LocalDate input = LocalDate.of(2016, 5, 3);
        final long expectedResult = 16924;

        CurryingToLongFunction<LocalDate> function = Currying.toLongFunction(Functions::dateToLong);

        long result = function.applyAsLong(input);
        assertThat(result, is(equalTo(expectedResult)));
    }

    @Test
    public void curry() {
        final LocalDate input = LocalDate.of(2016, 5, 3);
        final long expectedResult = 16924;

        CurryingToLongFunction<LocalDate> function = Currying.toLongFunction(Functions::dateToLong);

        CurryingLongSupplier curried = function.curry(input);
        long result = curried.getAsLong();
        assertThat(result, is(equalTo(expectedResult)));
    }

    @Test
    public void compose_function() {
        final String input = "2016-05-03";
        final long expectedResult = 16924;

        CurryingToLongFunction<LocalDate> function = Currying.toLongFunction(Functions::dateToLong);

        CurryingToLongFunction<String> compose = function.compose(str -> LocalDate.parse(str));
        assertThat(compose.applyAsLong(input), is(equalTo(expectedResult)));
    }

    @Test
    public void compose_biFunction() {
        final LocalDate inputA = LocalDate.of(2016, 5, 2);
        final Integer inputB = 1;
        final long expectedResult = 16924;

        CurryingToLongFunction<LocalDate> function = Currying.toLongFunction(Functions::dateToLong);

        CurryingToLongBiFunction<LocalDate, Integer> compose = function.compose(BiFunctions::addDays);
        assertThat(compose.applyAsLong(inputA, inputB), is(equalTo(expectedResult)));
    }

}
