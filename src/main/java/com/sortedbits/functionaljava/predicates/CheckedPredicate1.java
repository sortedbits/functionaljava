package com.sortedbits.functionaljava.predicates;

@FunctionalInterface
public interface CheckedPredicate1<T> extends Predicate1<T> {

    boolean testThrows(T x) throws Exception;

    default boolean test(T x) {
        try {
            return testThrows(x);
        } catch (Exception e) {
            throw new PredicateException(e);
        }
    }
}
