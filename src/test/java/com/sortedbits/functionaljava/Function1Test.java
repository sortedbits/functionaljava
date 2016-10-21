package com.sortedbits.functionaljava;

import com.sortedbits.functionaljava.functions.Function1;
import com.sortedbits.functionaljava.tuples.Tuple;
import com.sortedbits.functionaljava.tuples.Tuple1;
import org.junit.Test;

import static com.sortedbits.functionaljava.functions.Function.function1;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class Function1Test {

    @Test
    public void testFunction1() {
        Function1<Integer, Integer> f = function1(x -> x + 1);
        assertThat(f.apply(0), equalTo(1));
    }

    @Test
    public void testUntuple() {
        Function1<Tuple1<Integer>, Integer> ft = function1(x -> x._1 + 1);
        Function1<Integer, Integer> f = Function1.untuple(ft);
        assertThat(f.apply(0), equalTo(1));
    }

    @Test
    public void testTuple() {
        Function1<Integer, Integer> f = function1(x -> x + 1);
        Function1<Tuple1<Integer>, Integer> ft = f.tuple();
        assertThat(ft.apply(Tuple.of(0)), equalTo(1));
    }



}
