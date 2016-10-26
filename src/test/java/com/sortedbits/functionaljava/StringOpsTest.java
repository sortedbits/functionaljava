package com.sortedbits.functionaljava;

import org.junit.Test;

import static com.sortedbits.functionaljava.CollectionOps.list;
import static com.sortedbits.functionaljava.StringOps.mkString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class StringOpsTest {

    @Test
    public void mkStringTest() {
        assertThat(mkString(list(), ","), equalTo(""));
        assertThat(mkString(list(1), ","), equalTo("1"));
        assertThat(mkString(list(1, null), ","), equalTo("1,null"));
        assertThat(mkString(list(1, 2, 3), ","), equalTo("1,2,3"));
        assertThat(mkString(list(1, 2, 3), "(", ",", ")"), equalTo("(1,2,3)"));
    }
}
