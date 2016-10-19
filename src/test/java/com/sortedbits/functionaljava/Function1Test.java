package com.sortedbits.functionaljava;

import com.sortedbits.functionaljava.functions.Function1;
import com.sortedbits.functionaljava.tuples.Tuple;
import com.sortedbits.functionaljava.tuples.Tuple1;
import org.junit.Test;

import static com.sortedbits.functionaljava.functions.Function.function1;
import static org.junit.Assert.assertTrue;

public class Function1Test {

    @Test
    public void testCreate() {
        Function1<Integer, Integer> f1 = function1((Integer x) -> x + 1);
        assertTrue(f1.apply(0) == 1);
    }

    @Test
    public void testTupled() {
        Function1<Tuple1<Integer>, Integer> f1 = function1((Integer x) -> x + 1).tupled();
        assertTrue(f1.apply(Tuple.of(0)) == 1);
    }
}
