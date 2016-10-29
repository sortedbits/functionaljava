package com.sortedbits.functionaljava.predicates;

import com.sortedbits.functionaljava.functions.Function3;

@FunctionalInterface
public interface Predicate3<T1, T2, T3> extends Predicate, Function3<T1, T2, T3, Boolean> {

    boolean test(T1 x1, T2 x2, T3 x3);

    default int arity() {
        return 3;
    }

    default Boolean apply(T1 x1, T2 x2, T3 x3) {
        return test(x1, x2, x3);
    }
}
