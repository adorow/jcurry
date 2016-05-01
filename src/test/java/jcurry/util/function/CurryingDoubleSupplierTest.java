package jcurry.util.function;

import jcurry.util.Currying;
import jcurry.util.function.testdata.BiFunctions;
import jcurry.util.function.testdata.DoubleSuppliers;
import jcurry.util.function.testdata.Functions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(JUnit4.class)
public class CurryingDoubleSupplierTest {

    @Test
    public void defaultFunctionalityIsNotAffected() {
        double result = DoubleSuppliers.returnsOne();

        CurryingDoubleSupplier supplier = Currying.doubleSupplier(DoubleSuppliers::returnsOne);

        assertThat(supplier.getAsDouble(), is(equalTo(result)));
    }

    @Test
    public void andThen() {
        double result = DoubleSuppliers.returnsOne();

        CurryingDoubleSupplier supplier = Currying.doubleSupplier(DoubleSuppliers::returnsOne);

        CurryingSupplier<Double> newSupplier = supplier.andThen(Functions::addsOne);

        assertThat(newSupplier.get(), is(equalTo(Functions.addsOne(result))));
    }

    @Test
    public void andThenComposeInto() {
        double result = DoubleSuppliers.returnsOne();

        CurryingDoubleSupplier supplier = Currying.doubleSupplier(DoubleSuppliers::returnsOne);

        CurryingFunction<Double, Double> function = supplier.andThenComposeInto(BiFunctions::divide);

        Double param = 2.0;
        assertThat(function.apply(param), is(equalTo(BiFunctions.divide(result, param))));
    }

}
