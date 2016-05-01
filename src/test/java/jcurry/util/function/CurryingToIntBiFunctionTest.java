package jcurry.util.function;

import jcurry.util.Currying;
import jcurry.util.function.testdata.ToIntBiFunctions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(JUnit4.class)
public class CurryingToIntBiFunctionTest {

    @Test
    public void defaultFunctionalityIsNotAffected() {
        final Integer i1 = 10;
        final Integer i2 = 3;
        final int expectedResult = ToIntBiFunctions.divide(i1, i2);

        CurryingToIntBiFunction<Integer, Integer> biFunction = Currying.toIntBiFunction(ToIntBiFunctions::divide);

        int result = biFunction.applyAsInt(i1, i2);
        assertThat(result, is(equalTo(expectedResult)));
    }

    @Test
    public void curry_oneArg() {
        final Integer i1 = 10;
        final Integer i2 = 3;
        final int expectedResult = ToIntBiFunctions.divide(i1, i2);

        CurryingToIntBiFunction<Integer, Integer> biFunction = Currying.toIntBiFunction(ToIntBiFunctions::divide);

        CurryingToIntFunction<Integer> curried = biFunction.curry(i1);
        int result = curried.applyAsInt(i2);
        assertThat(result, is(equalTo(expectedResult)));
    }

    @Test
    public void curry_twoArgs() {
        final Integer i1 = 10;
        final Integer i2 = 3;
        final int expectedResult = ToIntBiFunctions.divide(i1, i2);

        CurryingToIntBiFunction<Integer, Integer> biFunction = Currying.toIntBiFunction(ToIntBiFunctions::divide);

        CurryingIntSupplier curried = biFunction.curry(i1, i2);
        int result = curried.getAsInt();
        assertThat(result, is(equalTo(expectedResult)));
    }

    @Test
    public void flip() {
        final Integer i1 = 10;
        final Integer i2 = 3;
        final int expectedResult = ToIntBiFunctions.divide(i1, i2);

        CurryingToIntBiFunction<Integer, Integer> biFunction = Currying.toIntBiFunction(ToIntBiFunctions::divide);

        CurryingToIntBiFunction<Integer, Integer> flipped = biFunction.flip();
        int result = flipped.applyAsInt(i2, i1);
        assertThat(result, is(equalTo(expectedResult)));
    }

}
