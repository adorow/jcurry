package jcurry.util.function;

import jcurry.util.Currying;
import jcurry.util.function.testdata.BiConsumers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;

@RunWith(JUnit4.class)
public class CurryingBiConsumerTest {

    @Test
    public void defaultFunctionalityIsNotAffected() {
        final List<Object> acc = new ArrayList<>();
        final String str1 = "foo";
        final String str2 = "bar";
        CurryingBiConsumer<String, String> stringBiConsumer = Currying.biConsumer(BiConsumers.biConsumerAddsToAccumulatorList(acc));

        stringBiConsumer.accept(str1, str2);
        assertThat(acc, hasSize(2));
        assertThat(acc, contains(str1, str2));
    }

    @Test
    public void curry() {
        final List<Object> acc = new ArrayList<>();
        final String str1 = "foo";
        final String str2 = "bar";
        CurryingBiConsumer<String, String> stringBiConsumer = Currying.biConsumer(BiConsumers.biConsumerAddsToAccumulatorList(acc));

        assertThat(acc, hasSize(0));
        CurryingConsumer<String> curried = stringBiConsumer.curry(str1);
        assertThat(acc, hasSize(0));
        curried.accept(str2);
        assertThat(acc, hasSize(2));
        assertThat(acc, contains(str1, str2));
    }

    @Test
    public void flip() {
        final List<Object> acc = new ArrayList<>();
        final LocalDate obj1 = LocalDate.MAX;
        final TimeUnit obj2 = TimeUnit.DAYS;
        final CurryingBiConsumer<LocalDate, TimeUnit> biConsumer = Currying.biConsumer(BiConsumers.biConsumerAddsToAccumulatorList(acc));

        // normal case:
        assertThat(acc, hasSize(0));

        biConsumer.accept(obj1, obj2);
        assertThat(acc, contains(obj1, obj2));

        // after flip:
        acc.clear();
        assertThat(acc, hasSize(0));

        CurryingBiConsumer<TimeUnit, LocalDate> flipped = biConsumer.flip();

        flipped.accept(obj2, obj1);
        // the order is still the same, because flipping the parameters does not change the original function
        assertThat(acc, contains(obj1, obj2));
    }



}
