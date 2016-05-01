package jcurry.util.function;

import jcurry.util.Currying;
import jcurry.util.function.testdata.BiFunctions;
import jcurry.util.function.testdata.BooleanSuppliers;
import jcurry.util.function.testdata.Functions;
import jcurry.util.function.testdata.Suppliers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.time.LocalDate;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(JUnit4.class)
public class CurryingSupplierTest {

    @Test
    public void defaultFunctionalityIsNotAffected() {
        LocalDate result = Suppliers.returnsToday();

        CurryingSupplier<LocalDate> supplier = Currying.supplier(Suppliers::returnsToday);

        assertThat(supplier.get(), is(equalTo(result)));
    }

    @Test
    public void andThen() {
        LocalDate result = Suppliers.returnsToday();

        CurryingSupplier<LocalDate> supplier = Currying.supplier(Suppliers::returnsToday);

        CurryingSupplier<LocalDate> newSupplier = supplier.andThen(Functions::addOneDay);

        assertThat(newSupplier.get(), is(equalTo(Functions.addOneDay(result))));
    }

    @Test
    public void andThenComposeInto() {
        LocalDate result = Suppliers.returnsToday();

        CurryingSupplier<LocalDate> supplier = Currying.supplier(Suppliers::returnsToday);

        CurryingFunction<Integer, LocalDate> function = supplier.andThenComposeInto(BiFunctions::addDays);

        int param = 1;
        assertThat(function.apply(param), is(equalTo(BiFunctions.addDays(result, param))));
    }

}
