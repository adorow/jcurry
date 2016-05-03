package jcurry.util.function;

import jcurry.util.Currying;
import jcurry.util.function.testdata.UnaryOperators;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(JUnit4.class)
public class CurryingIntUnaryOperatorTest {

    @Test
    public void defaultFunctionalityIsNotAffected() {
        final int v = 50;
        final int expectedResult = UnaryOperators.addOne(v);

        CurryingIntUnaryOperator unaryOperator = Currying.intUnaryOperator(UnaryOperators::addOne);

        int result = unaryOperator.applyAsInt(v);
        assertThat(result, is(equalTo(expectedResult)));
    }

    @Test
    public void curry() {
        final int v = 50;
        final int expectedResult = UnaryOperators.addOne(v);

        CurryingIntUnaryOperator unaryOperator = Currying.intUnaryOperator(UnaryOperators::addOne);

        CurryingIntSupplier curried = unaryOperator.curry(v);
        int result = curried.getAsInt();
        assertThat(result, is(equalTo(expectedResult)));
    }

}
