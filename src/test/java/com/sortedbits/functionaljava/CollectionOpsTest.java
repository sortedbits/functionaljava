package com.sortedbits.functionaljava;

import com.sortedbits.functionaljava.tuples.Tuple;
import org.junit.Test;

import java.util.Map;

import static com.sortedbits.functionaljava.CollectionOps.list;
import static com.sortedbits.functionaljava.StringOps.mkString;
import static com.sortedbits.functionaljava.tuples.Tuple.UNIT;
import static com.sortedbits.functionaljava.tuples.Tuple.pair;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class CollectionOpsTest {

    @Test
    public void mapTest() {
        Map<?, ?> m0 = CollectionOps.map();
        assertThat(m0.size(), equalTo(0));

        Map<Integer, String> m1 = CollectionOps.map(pair(1, "a"));
        assertThat(m1.size(), equalTo(1));
        assertThat(m1.get(1), equalTo("a"));

        Map<Integer, String> m2 = CollectionOps.map(pair(1, "a"), pair(2, "b"));
        assertThat(m2.size(), equalTo(2));
        assertThat(m2.get(1), equalTo("a"));
        assertThat(m2.get(2), equalTo("b"));

        Map<Integer, String> m21 = CollectionOps.map(pair(1, "a"), pair(1, "b"));
        assertThat(m21.size(), equalTo(1));
        assertThat(m21.get(1), equalTo("b"));
    }
}
