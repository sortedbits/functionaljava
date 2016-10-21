package com.sortedbits.functionaljava;

import com.sortedbits.functionaljava.functions.Function0;

import com.sortedbits.functionaljava.suppliers.Supplier1;
import org.junit.Test;

import java.util.function.Function;

import static com.sortedbits.functionaljava.functions.Function.function0;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class Function0Test {

    @Test
    public void testFunction() {
        Supplier1<Integer> s = () ->  1;
        Function<Void, Integer> f = s.function();
        assertThat(f.apply(null), equalTo(1));
    }

    @Test
    public void testFunction0() {
        Function0<Integer> f = function0(() ->  1);
        assertThat(f.apply(), equalTo(1));
    }
}
