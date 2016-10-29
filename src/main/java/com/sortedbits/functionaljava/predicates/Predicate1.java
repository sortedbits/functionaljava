package com.sortedbits.functionaljava.predicates;

import com.sortedbits.functionaljava.functions.Function1;

@FunctionalInterface
public interface Predicate1<T> extends Predicate, java.util.function.Predicate<T>, Function1<T, Boolean> {

    @Override boolean test(T x);

    default int arity() {
        return 1;
    }

    default Boolean apply(T x) {
        return test(x);
    }
}
