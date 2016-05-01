package jcurry.util.function;

import jcurry.util.Currying;
import jcurry.util.function.testdata.BiPredicates;
import jcurry.util.function.testdata.BiPredicates;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(JUnit4.class)
public class CurryingBiPredicateTest {

    @Test
    public void defaultFunctionalityIsNotAffected() {
        final Integer int1 = 3;
        final Long long1 = 7L;
        final boolean expectedResult = BiPredicates.isFirstElementSmallerThan5(int1, long1);

        CurryingBiPredicate<Integer, Long> biPredicate = Currying.biPredicate(BiPredicates::isFirstElementSmallerThan5);

        boolean result = biPredicate.test(int1, long1);
        assertThat(result, is(equalTo(expectedResult)));
    }

    @Test
    public void curry_oneArg() {
        final Integer int1 = 3;
        final Long long1 = 7L;
        final boolean expectedResult = BiPredicates.isFirstElementSmallerThan5(int1, long1);

        CurryingBiPredicate<Integer, Long> biPredicate = Currying.biPredicate(BiPredicates::isFirstElementSmallerThan5);

        CurryingPredicate<Long> curried = biPredicate.curry(int1);
        boolean result = curried.test(long1);
        assertThat(result, is(equalTo(expectedResult)));
    }

    @Test
    public void curry_twoArgs() {
        final Integer int1 = 3;
        final Long long1 = 7L;
        final boolean expectedResult = BiPredicates.isFirstElementSmallerThan5(int1, long1);

        CurryingBiPredicate<Integer, Long> biPredicate = Currying.biPredicate(BiPredicates::isFirstElementSmallerThan5);

        CurryingBooleanSupplier curried = biPredicate.curry(int1, long1);
        boolean result = curried.getAsBoolean();
        assertThat(result, is(equalTo(expectedResult)));
    }

    @Test
    public void flip() {
        final Integer int1 = 3;
        final Long long1 = 7L;
        final boolean expectedResult = BiPredicates.isFirstElementSmallerThan5(int1, long1);

        CurryingBiPredicate<Integer, Long> biPredicate = Currying.biPredicate(BiPredicates::isFirstElementSmallerThan5);

        CurryingBiPredicate<Long, Integer> flipped = biPredicate.flip();
        boolean result = flipped.test(long1, int1);
        assertThat(result, is(equalTo(expectedResult)));
    }

}
