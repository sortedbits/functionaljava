package com.sortedbits.functionaljava.predicates;

import com.sortedbits.functionaljava.functions.Function2;

@FunctionalInterface
public interface Predicate2<T1, T2> extends Predicate, java.util.function.BiPredicate<T1, T2>, Function2<T1, T2, Boolean> {

    @Override boolean test(T1 x1, T2 x2);

    default Boolean apply(T1 x1, T2 x2) {
        return test(x1, x2);
    }
}
