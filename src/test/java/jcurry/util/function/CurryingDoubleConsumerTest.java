package jcurry.util.function;

import jcurry.util.Currying;
import jcurry.util.function.testdata.Consumers;
import jcurry.util.function.testdata.DoubleConsumers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;

@RunWith(JUnit4.class)
public class CurryingDoubleConsumerTest {

    @Test
    public void defaultFunctionalityIsNotAffected() {
        final List<Double> acc = new ArrayList<>();
        final Double d1 = 4.5;
        CurryingDoubleConsumer consumer = Currying.doubleConsumer(DoubleConsumers.consumerAddsToAccumulatorList(acc));

        consumer.accept(d1);
        assertThat(acc, hasSize(1));
        assertThat(acc, contains(d1));
    }

}
