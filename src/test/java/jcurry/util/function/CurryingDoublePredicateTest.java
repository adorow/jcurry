package jcurry.util.function;

import jcurry.util.Currying;
import jcurry.util.function.testdata.Predicates;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(JUnit4.class)
public class CurryingDoublePredicateTest {

    @Test
    public void defaultFunctionalityIsNotAffected() {
        final double v1 = 3.0;
        final boolean expectedResult = Predicates.isZero(v1);

        CurryingDoublePredicate predicate = Currying.doublePredicate(Predicates::isZero);

        boolean result = predicate.test(v1);
        assertThat(result, is(equalTo(expectedResult)));
    }

    @Test
    public void curry() {
        final double v1 = 0.0;
        final boolean expectedResult = Predicates.isZero(v1);

        CurryingDoublePredicate predicate = Currying.doublePredicate(Predicates::isZero);

        CurryingBooleanSupplier curried = predicate.curry(v1);
        boolean result = curried.getAsBoolean();
        assertThat(result, is(equalTo(expectedResult)));
    }

}
