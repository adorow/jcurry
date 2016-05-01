package jcurry.util.function;

import jcurry.util.Currying;
import jcurry.util.function.testdata.ToDoubleBiFunctions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(JUnit4.class)
public class CurryingToDoubleBiFunctionTest {

    @Test
    public void defaultFunctionalityIsNotAffected() {
        final Double d1 = 10.0;
        final Double d2 = 3.0;
        final double expectedResult = ToDoubleBiFunctions.divide(d1, d2);

        CurryingToDoubleBiFunction<Double, Double> biFunction = Currying.toDoubleBiFunction(ToDoubleBiFunctions::divide);

        double result = biFunction.applyAsDouble(d1, d2);
        assertThat(result, is(equalTo(expectedResult)));
    }

    @Test
    public void curry_oneArg() {
        final Double d1 = 10.0;
        final Double d2 = 3.0;
        final double expectedResult = ToDoubleBiFunctions.divide(d1, d2);

        CurryingToDoubleBiFunction<Double, Double> biFunction = Currying.toDoubleBiFunction(ToDoubleBiFunctions::divide);

        CurryingToDoubleFunction<Double> curried = biFunction.curry(d1);
        double result = curried.applyAsDouble(d2);
        assertThat(result, is(equalTo(expectedResult)));
    }

    @Test
    public void curry_twoArgs() {
        final Double d1 = 10.0;
        final Double d2 = 3.0;
        final double expectedResult = ToDoubleBiFunctions.divide(d1, d2);

        CurryingToDoubleBiFunction<Double, Double> biFunction = Currying.toDoubleBiFunction(ToDoubleBiFunctions::divide);

        CurryingDoubleSupplier curried = biFunction.curry(d1, d2);
        double result = curried.getAsDouble();
        assertThat(result, is(equalTo(expectedResult)));
    }

    @Test
    public void flip() {
        final Double d1 = 10.0;
        final Double d2 = 3.0;
        final double expectedResult = ToDoubleBiFunctions.divide(d1, d2);

        CurryingToDoubleBiFunction<Double, Double> biFunction = Currying.toDoubleBiFunction(ToDoubleBiFunctions::divide);

        CurryingToDoubleBiFunction<Double, Double> flipped = biFunction.flip();
        double result = flipped.applyAsDouble(d2, d1);
        assertThat(result, is(equalTo(expectedResult)));
    }

}
