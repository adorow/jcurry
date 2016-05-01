package jcurry.util.function;

import jcurry.util.Currying;
import jcurry.util.function.testdata.BiFunctions;
import jcurry.util.function.testdata.Functions;
import jcurry.util.function.testdata.LongSuppliers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(JUnit4.class)
public class CurryingLongSupplierTest {

    @Test
    public void defaultFunctionalityIsNotAffected() {
        long result = LongSuppliers.returnsOne();

        CurryingLongSupplier supplier = Currying.longSupplier(LongSuppliers::returnsOne);

        assertThat(supplier.getAsLong(), is(equalTo(result)));
    }

    @Test
    public void andThen() {
        long result = LongSuppliers.returnsOne();

        CurryingLongSupplier supplier = Currying.longSupplier(LongSuppliers::returnsOne);

        CurryingSupplier<Long> newSupplier = supplier.andThen(Functions::addsOne);

        assertThat(newSupplier.get(), is(equalTo(Functions.addsOne(result))));
    }

    @Test
    public void andThenComposeInto() {
        long result = LongSuppliers.returnsOne();

        CurryingLongSupplier supplier = Currying.longSupplier(LongSuppliers::returnsOne);

        CurryingFunction<Long, Long> function = supplier.andThenComposeInto(BiFunctions::divide);

        Long param = 2L;
        assertThat(function.apply(param), is(equalTo(BiFunctions.divide(result, param))));
    }

}
