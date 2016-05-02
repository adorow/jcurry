package jcurry.util.function;

import jcurry.util.Currying;
import jcurry.util.function.testdata.BiConsumers;
import jcurry.util.function.testdata.Consumers;
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
public class CurryingConsumerTest {

    @Test
    public void defaultFunctionalityIsNotAffected() {
        final List<Object> acc = new ArrayList<>();
        final String str1 = "foo";
        CurryingConsumer<String> stringConsumer = Currying.consumer(Consumers.consumerAddsToAccumulatorList(acc));

        stringConsumer.accept(str1);
        assertThat(acc, hasSize(1));
        assertThat(acc, contains(str1));
    }

}
