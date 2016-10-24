package com.sortedbits.functionaljava.functions;

import com.sortedbits.functionaljava.tuples.Tuple;
import com.sortedbits.functionaljava.tuples.Tuple3;

@FunctionalInterface
public interface Function3<T1, T2, T3, R> extends Function {

    R apply(T1 x1, T2 x2, T3 x3);

    default int arity() {
        return 3;
    }

    default Function1<Tuple3<T1, T2, T3>, R> tuple() {
        return t -> apply(t._1, t._2, t._3);
    }

    default Function1<T1, Function1<T2, Function1<T3, R>>> curry() {
        return x1 -> x2 -> x3 -> apply(x1, x2, x3);
    }

    default Function2<T2, T3, R> apply(T1 x1) {
        return (x2, x3) -> apply(x1, x2, x3);
    }

    default Function1<T3, R> apply(T1 x1, T2 x2) {
        return x3 -> apply(x1, x2, x3);
    }

    default <V> Function3<T1, T2, T3, V> andThen(java.util.function.Function<? super R, ? extends V> after) {
        return (T1 x1, T2 x2, T3 x3) -> after.apply(apply(x1, x2, x3));
    }

    static <T1, T2, T3, R> Function3<T1, T2, T3, R> untuple(java.util.function.Function<Tuple3<T1, T2, T3>, R> f) {
        return (x1, x2, x3) -> f.apply(Tuple.of(x1, x2, x3));
    }

    static <T1, T2, T3, R> Function3<T1, T2, T3, R> uncurry(java.util.function.Function<T1, java.util.function.Function<T2, java.util.function.Function<T3, R>>> f) {
        return (x1, x2, x3) -> f.apply(x1).apply(x2).apply(x3);
    }
}
