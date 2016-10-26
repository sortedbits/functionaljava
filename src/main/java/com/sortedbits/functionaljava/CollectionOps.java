package com.sortedbits.functionaljava;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toMap;

public interface CollectionOps {

    static <T> List<T> list(T...xs) {
        return Arrays.asList(xs);
    }

    static <K, V> Map<K, V> map(Map.Entry<K, V>...xs) {
        return Arrays.stream(xs).collect(toMap(x -> x.getKey(), x -> x.getValue(), (x1, x2) -> x2));
    }
}
