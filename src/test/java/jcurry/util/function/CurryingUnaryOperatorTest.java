package jcurry.util.function;

import jcurry.util.Currying;
import jcurry.util.function.testdata.BinaryOperators;
import jcurry.util.function.testdata.UnaryOperators;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(JUnit4.class)
public class CurryingUnaryOperatorTest {

    @Test
    public void defaultFunctionalityIsNotAffected() {
        final Integer int1 = 50;
        final Integer expectedResult = UnaryOperators.addOne(int1);

        CurryingUnaryOperator<Integer> unaryOperator = Currying.unaryOperator(UnaryOperators::addOne);

        Integer result = unaryOperator.apply(int1);
        assertThat(result, is(equalTo(expectedResult)));
    }

    @Test
    public void curry() {
        final Integer int1 = 50;
        final Integer expectedResult = UnaryOperators.addOne(int1);

        CurryingUnaryOperator<Integer> unaryOperator = Currying.unaryOperator(UnaryOperators::addOne);

        CurryingSupplier<Integer> curried = unaryOperator.curry(int1);
        Integer result = curried.get();
        assertThat(result, is(equalTo(expectedResult)));
    }

}
