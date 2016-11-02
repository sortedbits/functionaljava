package com.sortedbits.functionaljava.predicates;

@FunctionalInterface
public interface CheckedPredicate2<T1, T2> extends Predicate2<T1, T2> {

    boolean testThrows(T1 x1, T2 x2) throws Exception;

    default boolean test(T1 x1, T2 x2) {
        try {
            return testThrows(x1, x2);
        } catch (Exception e) {
            throw new PredicateException(e);
        }
    }
}
