package jcurry.util.function;

import jcurry.util.Currying;
import jcurry.util.function.testdata.BiFunctions;
import jcurry.util.function.testdata.IntSuppliers;
import jcurry.util.function.testdata.Functions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(JUnit4.class)
public class CurryingIntSupplierTest {

    @Test
    public void defaultFunctionalityIsNotAffected() {
        int result = IntSuppliers.returnsOne();

        CurryingIntSupplier supplier = Currying.intSupplier(IntSuppliers::returnsOne);

        assertThat(supplier.getAsInt(), is(equalTo(result)));
    }

    @Test
    public void andThen() {
        int result = IntSuppliers.returnsOne();

        CurryingIntSupplier supplier = Currying.intSupplier(IntSuppliers::returnsOne);

        CurryingSupplier<Integer> newSupplier = supplier.andThen(Functions::addsOne);

        assertThat(newSupplier.get(), is(equalTo(Functions.addsOne(result))));
    }

    @Test
    public void andThenComposeInto() {
        int result = IntSuppliers.returnsOne();

        CurryingIntSupplier supplier = Currying.intSupplier(IntSuppliers::returnsOne);

        CurryingFunction<Integer, Integer> function = supplier.andThenComposeInto(BiFunctions::divide);

        Integer param = 2;
        assertThat(function.apply(param), is(equalTo(BiFunctions.divide(result, param))));
    }

}
