package com.sortedbits.functionaljava.predicates;

@FunctionalInterface
public interface CheckedPredicate3<T1, T2, T3> extends Predicate3<T1, T2, T3> {

    boolean testThrows(T1 x1, T2 x2, T3 x3) throws Exception;

    default boolean test(T1 x1, T2 x2, T3 x3) {
        try {
            return testThrows(x1, x2, x3);
        } catch (Exception e) {
            throw new PredicateException(e);
        }
    }
}
