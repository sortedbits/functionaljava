package com.sortedbits.functionaljava;

import org.junit.Test;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class StreamOpsTest {

    /*
    @Test
    public void headTest() {
        Stream xs = Stream.of(1, 2, 3);
        assertThat(head(xs), equalTo(1));
    }

    @Test
    public void tailTest() {
        Integer[] xs = new Integer[] { 1, 2, 3 };
        assertThat(head(tail(Stream.of(xs))), equalTo(2));
        assertThat(head(tail(tail(Stream.of(xs)))), equalTo(3));
    }

    @Test
    public void foldLeftTest() {
        String[] xs = new String[] { "a", "b", "c" };
        assertThat(foldLeft(Stream.of(xs), "!", (x, y) -> x + y), equalTo("!abc"));
    }
    */
}
