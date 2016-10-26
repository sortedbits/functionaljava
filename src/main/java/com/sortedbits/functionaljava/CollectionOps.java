package com.sortedbits.functionaljava;

import com.sortedbits.functionaljava.tuples.Tuple2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface CollectionOps {

    static <T> List<T> list(T...xs) {
        return Arrays.asList(xs);
    }

//    static <A, B> Map<A, B> map(Tuple2<A, B>...xs) {
//        Map<A, B> m = new HashMap<>();
//        Arrays.stream(xs).forEach(e -> m.put(e.getKey(), e.getValue()));
//        return m;
//    }

}
