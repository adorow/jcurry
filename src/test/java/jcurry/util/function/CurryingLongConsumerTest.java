package jcurry.util.function;

import jcurry.util.Currying;
import jcurry.util.function.testdata.LongConsumers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;

@RunWith(JUnit4.class)
public class CurryingLongConsumerTest {

    @Test
    public void defaultFunctionalityIsNotAffected() {
        final List<Long> acc = new ArrayList<>();
        final Long l1 = 55L;
        CurryingLongConsumer consumer = Currying.longConsumer(LongConsumers.consumerAddsToAccumulatorList(acc));

        consumer.accept(l1);
        assertThat(acc, hasSize(1));
        assertThat(acc, contains(l1));
    }

}
