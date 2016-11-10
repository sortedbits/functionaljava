package com.sortedbits.functionaljava;


import com.sortedbits.functionaljava.control.TailCall;
import org.junit.Test;

import static com.sortedbits.functionaljava.control.TailCalls.call;
import static com.sortedbits.functionaljava.control.TailCalls.done;

public class TailRecTest {

    static int NUM = 20000;

    @Test(expected = java.lang.StackOverflowError.class)
    public void testStackOverflow() {
        factorial(1, NUM);
    }

    @Test
    public void testNoStackOverflow() {
        factorialTailRec(1, NUM);
    }

    static int factorial(int acc, int number) {
        if (number == 0) {
            return acc;
        } else {
            return factorial(acc * number, number -1);
        }
    }
    static TailCall<Integer> factorialTailRec(int acc, int number) {
        if (number == 0) {
            return done(acc);
        } else {
            return call(() -> factorialTailRec(acc * number, number - 1));
        }
    }
}
