package com.sortedbits.functionaljava.functions;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CheckedFunction0Test {

    @Test
    public void testCheckedFunction0() {
        CheckedFunction0<Integer> f = () -> 1;
        assertThat(f.apply(), equalTo(1));
    }

    @Test(expected=FunctionException.class)
    public void testCheckedFunction0Error() {
        CheckedFunction0<Integer> f = () -> { throw new Exception("function error"); };
        f.apply();
    }
}
