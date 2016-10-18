package com.sortedbits.functionaljava.functions;

import com.sortedbits.functionaljava.tuples.Tuple;
import com.sortedbits.functionaljava.tuples.Tuple4;

@FunctionalInterface
public interface Function4<T1, T2, T3, T4, R> {

    R apply(T1 x1, T2 x2, T3 x3, T4 x4);

    default Function1<Tuple4<T1, T2, T3, T4>, R> tupled() {
        return t -> apply(t._1, t._2, t._3, t._4);
    }

    default Function1<T1, Function1<T2, Function1<T3, Function1<T4, R>>>> curried() {
        return x1 -> x2 -> x3 -> x4 -> apply(x1, x2, x3, x4);
    }

    default Function3<T2, T3, T4, R> applied(T1 x1) {
        return (x2, x3, x4) -> apply(x1, x2, x3, x4);
    }
    
    default Function2<T3, T4, R> applied(T1 x1, T2 x2) {
        return (x3, x4) -> apply(x1, x2, x3, x4);
    }

    default Function1<T4, R> applied(T1 x1, T2 x2, T3 x3) {
        return x4 -> apply(x1, x2, x3, x4);
    }

    static <T1, T2, T3, T4, R> Function4<T1, T2, T3, T4, R> untupled(Function1<Tuple4<T1, T2, T3, T4>, R> f) {
        return (x1, x2, x3, x4) -> f.apply(Tuple.of(x1, x2, x3, x4));
    }

    static <T1, T2, T3, T4, R> Function4<T1, T2, T3, T4, R> uncurried(Function1<T1, Function1<T2, Function1<T3, Function1<T4, R>>>> f) {
        return (x1, x2, x3, x4) -> f.apply(x1).apply(x2).apply(x3).apply(x4);
    }

}
