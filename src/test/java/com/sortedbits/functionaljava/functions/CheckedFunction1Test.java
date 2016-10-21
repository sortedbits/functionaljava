package com.sortedbits.functionaljava.functions;

import com.sortedbits.functionaljava.UncheckedException;
import com.sortedbits.functionaljava.functions.CheckedFunction1;
import com.sortedbits.functionaljava.functions.Function1;
import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class CheckedFunction1Test {

    @Test(expected=UncheckedException.class)
    public void testChecked() {
        CheckedFunction1<Integer, ?> cf = x -> { throw new Exception(); };
        cf.apply(0);
    }

    @Test(expected=UncheckedException.class)
    public void testAndThenCheched1() {
        Function1<Integer, Integer> f1 = x -> x + 1;
        CheckedFunction1<Integer, ?> f2 = x -> { throw new Exception(); };
        Function1<Integer, ?> f = f1.andThen(f2);
        f.apply(0);
    }

    public void testAndThenCheched2() {
        Function1<Integer, Integer> f1 = x -> x + 1;
        CheckedFunction1<Integer, Integer> f2 = x -> x * 2;
        Function1<Integer, Integer> f = f1.andThen(f2);
        assertThat(f.apply(0), equalTo(2));
    }

    @Test(expected=UncheckedException.class)
    public void testCheckedAndThen1() {
        CheckedFunction1<Integer, Integer> f1 = x -> { throw new Exception(); };
        Function1<Integer, Integer> f2 = x -> x + 1;
        Function1<Integer, Integer> f = f1.andThen(f2);
        f.apply(0);
    }

    public void testCheckedAndThen2() {
        CheckedFunction1<Integer, Integer> f1 = x -> x + 1;
        Function1<Integer, Integer> f2 = x -> x * 2;
        Function1<Integer, Integer> f = f1.andThen(f2);
        f.apply(2);
    }
}
