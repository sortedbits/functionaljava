package com.sortedbits.functionaljava.functions;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

import com.sortedbits.functionaljava.suppliers.CheckedSupplier;
import com.sortedbits.functionaljava.suppliers.Supplier;
import com.sortedbits.functionaljava.suppliers.SupplierException;

public class Function0Test {

    @Test
    public void testFunction0() {
        Function0<Integer> f = () -> 1;
        assertThat(f.apply(), equalTo(1));
    }

    @Test
    public void testSupplier1ToFunction0() {
        Supplier<Integer> s = () ->  1;
        Function0<Integer> f = s.function0();
        assertThat(f.apply(), equalTo(1));
    }

    @Test
    public void testCheckedSupplier1ToFunction0() {
        CheckedSupplier<Integer> s = () ->  1;
        Function0<Integer> f = s.function0();
        assertThat(f.apply(), equalTo(1));
    }

    @Test(expected=SupplierException.class)
    public void testCheckedSupplier1ToFunction0Error() {
        CheckedSupplier<?> s = () -> { throw new Exception("supplier exception"); };
        Function0<?> f = s.function0();
        f.apply();
    }
}
