package com.sortedbits.functionaljava;

import com.sortedbits.functionaljava.tuples.Tuple;
import com.sortedbits.functionaljava.tuples.Tuple2;

import java.util.*;

public interface CollectionOps {

    static <T> List<T> list(T...xs) {
        return Arrays.asList(xs);
    }
}
