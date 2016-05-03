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
public class CurryingToDoubleFunctionTest {

    @Test
    public void defaultFunctionalityIsNotAffected() {
        final LocalDate input = LocalDate.of(2016, 5, 3);
        final double expectedResult = 16924;

        CurryingToDoubleFunction<LocalDate> function = Currying.toDoubleFunction(Functions::dateToDouble);

        double result = function.applyAsDouble(input);
        assertThat(result, is(equalTo(expectedResult)));
    }

    @Test
    public void curry() {
        final LocalDate input = LocalDate.of(2016, 5, 3);
        final double expectedResult = 16924;

        CurryingToDoubleFunction<LocalDate> function = Currying.toDoubleFunction(Functions::dateToDouble);

        CurryingDoubleSupplier curried = function.curry(input);
        double result = curried.getAsDouble();
        assertThat(result, is(equalTo(expectedResult)));
    }

    @Test
    public void compose_function() {
        final String input = "2016-05-03";
        final double expectedResult = 16924;

        CurryingToDoubleFunction<LocalDate> function = Currying.toDoubleFunction(Functions::dateToDouble);

        CurryingToDoubleFunction<String> compose = function.compose(str -> LocalDate.parse(str));
        assertThat(compose.applyAsDouble(input), is(equalTo(expectedResult)));
    }

    @Test
    public void compose_biFunction() {
        final LocalDate inputA = LocalDate.of(2016, 5, 2);
        final Integer inputB = 1;
        final double expectedResult = 16924;

        CurryingToDoubleFunction<LocalDate> function = Currying.toDoubleFunction(Functions::dateToDouble);

        CurryingToDoubleBiFunction<LocalDate, Integer> compose = function.compose(BiFunctions::addDays);
        assertThat(compose.applyAsDouble(inputA, inputB), is(equalTo(expectedResult)));
    }

}
