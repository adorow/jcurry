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
public class CurryingLongUnaryOperatorTest {

    @Test
    public void defaultFunctionalityIsNotAffected() {
        final long v = 50;
        final long expectedResult = UnaryOperators.addOne(v);

        CurryingLongUnaryOperator unaryOperator = Currying.longUnaryOperator(UnaryOperators::addOne);

        long result = unaryOperator.applyAsLong(v);
        assertThat(result, is(equalTo(expectedResult)));
    }

    @Test
    public void curry() {
        final long v = 50;
        final long expectedResult = UnaryOperators.addOne(v);

        CurryingLongUnaryOperator unaryOperator = Currying.longUnaryOperator(UnaryOperators::addOne);

        CurryingLongSupplier curried = unaryOperator.curry(v);
        long result = curried.getAsLong();
        assertThat(result, is(equalTo(expectedResult)));
    }

}
