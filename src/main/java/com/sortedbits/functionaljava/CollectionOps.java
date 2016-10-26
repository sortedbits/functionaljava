package com.sortedbits.functionaljava;

import java.util.*;

public interface CollectionOps {

    static <T> List<T> list(T...xs) {
        return Arrays.asList(xs);
    }
}
