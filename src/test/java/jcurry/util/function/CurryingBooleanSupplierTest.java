package jcurry.util.function;

import jcurry.util.Currying;
import jcurry.util.function.testdata.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.function.BooleanSupplier;
import java.util.function.Function;
import java.util.function.Supplier;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(JUnit4.class)
public class CurryingBooleanSupplierTest {

    @Test
    public void defaultFunctionalityIsNotAffected() {
        boolean result = BooleanSuppliers.returnsTrue();

        CurryingBooleanSupplier supplier = Currying.booleanSupplier(BooleanSuppliers::returnsTrue);

        assertThat(supplier.getAsBoolean(), is(equalTo(result)));
    }

    @Test
    public void andThen() {
        boolean result = BooleanSuppliers.returnsTrue();

        CurryingBooleanSupplier supplier = Currying.booleanSupplier(BooleanSuppliers::returnsTrue);

        CurryingSupplier<Integer> newSupplier = supplier.andThen(Functions::binaryFromBoolean);

        assertThat(newSupplier.get(), is(equalTo(Functions.binaryFromBoolean(result))));
    }

    @Test
    public void andThenComposeInto() {
        boolean result = BooleanSuppliers.returnsTrue();

        CurryingBooleanSupplier supplier = Currying.booleanSupplier(BooleanSuppliers::returnsTrue);

        CurryingFunction<String, String> function = supplier.andThenComposeInto(BiFunctions::concatenateBooleanAndStr);

        String str = "text";
        assertThat(function.apply(str), is(equalTo(result + str)));
    }

    @Test
    public void negate() {
        boolean result = !BooleanSuppliers.returnsTrue();

        CurryingBooleanSupplier supplier = Currying.booleanSupplier(BooleanSuppliers::returnsTrue);

        CurryingBooleanSupplier negatedSupplier = supplier.negate();

        assertThat(negatedSupplier.getAsBoolean(), is(equalTo(result)));
    }

    @Test
    public void thenElse_objects() {
        CurryingBooleanSupplier trueSupplier = Currying.booleanSupplier(BooleanSuppliers::returnsTrue);
        CurryingBooleanSupplier falseSupplier = Currying.booleanSupplier(BooleanSuppliers::returnsFalse);

        Integer a = 1;
        Integer b = 2;
        assertThat(trueSupplier.thenElse(a, b).get(), is(equalTo(a)));
        assertThat(falseSupplier.thenElse(a, b).get(), is(equalTo(b)));
    }

    @Test
    public void thenElse_suppliers() {
        CurryingBooleanSupplier trueSupplier = Currying.booleanSupplier(BooleanSuppliers::returnsTrue);
        CurryingBooleanSupplier falseSupplier = Currying.booleanSupplier(BooleanSuppliers::returnsFalse);

        Integer a = 1;
        Integer b = 2;
        Supplier<Integer> sa = Suppliers.supply(a);
        Supplier<Integer> sb = Suppliers.supply(b);
        assertThat(trueSupplier.thenElse(sa, sb).get(), is(equalTo(a)));
        assertThat(falseSupplier.thenElse(sa, sb).get(), is(equalTo(b)));
    }

}
