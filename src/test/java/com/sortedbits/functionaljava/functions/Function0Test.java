package com.sortedbits.functionaljava.functions;

import com.sortedbits.functionaljava.suppliers.CheckedSupplier1;
import com.sortedbits.functionaljava.suppliers.Supplier1;
import com.sortedbits.functionaljava.suppliers.SupplierException;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class Function0Test {

    @Test
    public void testFunction0() {
        Function0<Integer> f = () -> 1;
        assertThat(f.apply(), equalTo(1));
    }

    @Test
    public void testSupplier1ToFunction0() {
        Supplier1<Integer> s = () ->  1;
        Function0<Integer> f = s.function0();
        assertThat(f.apply(), equalTo(1));
    }

    @Test
    public void testCheckedSupplier1ToFunction0() {
        CheckedSupplier1<Integer> s = () ->  1;
        Function0<Integer> f = s.function0();
        assertThat(f.apply(), equalTo(1));
    }

    @Test(expected=SupplierException.class)
    public void testCheckedSupplier1ToFunction0Error() {
        CheckedSupplier1<?> s = () -> { throw new Exception("supplier exception"); };
        Function0<Integer> f = s.function0();
        f.apply();
    }
}
