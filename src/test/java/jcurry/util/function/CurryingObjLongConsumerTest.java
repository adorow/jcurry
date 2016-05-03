package jcurry.util.function;

import jcurry.util.Currying;
import jcurry.util.function.testdata.BiConsumers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;

@RunWith(JUnit4.class)
public class CurryingObjLongConsumerTest {

    @Test
    public void defaultFunctionalityIsNotAffected() {
        final List<Object> acc = new ArrayList<>();
        final String str1 = "foo";
        final long v1 = 1;
        CurryingObjLongConsumer<String> biConsumer = Currying.objLongConsumer(BiConsumers.objLongConsumerAddsToAccumulatorList(acc));

        biConsumer.accept(str1, v1);
        assertThat(acc, hasSize(2));
        assertThat(acc, contains(str1, v1));
    }

    @Test
    public void curry() {
        final List<Object> acc = new ArrayList<>();
        final String str1 = "foo";
        final long v1 = 1;
        CurryingObjLongConsumer<String> biConsumer = Currying.objLongConsumer(BiConsumers.objLongConsumerAddsToAccumulatorList(acc));

        assertThat(acc, hasSize(0));
        CurryingLongConsumer curried = biConsumer.curry(str1);
        assertThat(acc, hasSize(0));
        curried.accept(v1);
        assertThat(acc, hasSize(2));
        assertThat(acc, contains(str1, v1));
    }

    @Test
    public void flip() {
        final List<Object> acc = new ArrayList<>();
        final String str1 = "foo";
        final long v1 = 1;
        CurryingObjLongConsumer<String> biConsumer = Currying.objLongConsumer(BiConsumers.objLongConsumerAddsToAccumulatorList(acc));

        // normal case:
        assertThat(acc, hasSize(0));

        biConsumer.accept(str1, v1);
        assertThat(acc, contains(str1, v1));

        // after flip:
        acc.clear();
        assertThat(acc, hasSize(0));

        CurryingBiConsumer<Long, String> flipped = biConsumer.flip();

        flipped.accept(v1, str1);
        // the order is still the same, because flipping the parameters does not change the original function
        assertThat(acc, contains(str1, v1));
    }



}
