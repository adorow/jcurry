package jcurry.util.function;

import jcurry.util.Currying;
import jcurry.util.function.testdata.IntConsumers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;

@RunWith(JUnit4.class)
public class CurryingIntConsumerTest {

    @Test
    public void defaultFunctionalityIsNotAffected() {
        final List<Integer> acc = new ArrayList<>();
        final Integer i1 = 27;
        CurryingIntConsumer consumer = Currying.intConsumer(IntConsumers.consumerAddsToAccumulatorList(acc));

        consumer.accept(i1);
        assertThat(acc, hasSize(1));
        assertThat(acc, contains(i1));
    }

}
