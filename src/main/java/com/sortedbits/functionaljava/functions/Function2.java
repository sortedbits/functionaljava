package com.sortedbits.functionaljava.functions;

import com.sortedbits.functionaljava.tuples.Tuple;
import com.sortedbits.functionaljava.tuples.Tuple2;

import java.util.function.BiFunction;

@FunctionalInterface
public interface Function2<T1, T2, R> extends BiFunction<T1, T2, R>, Function {

    @Override
    R apply(T1 x1, T2 x2);

    default int arity() {
        return 2;
    }

    default Function1<Tuple2<T1, T2>, R> tupled() {
        return t -> this.apply(t._1, t._2);
    }

    default Function1<T1, Function1<T2, R>> curried() {
        return x1 -> x2 -> apply(x1, x2);
    }

    default Function1<T2, R> applied(T1 x1) {
        return x2 -> apply(x1, x2);
    }

    static <T1, T2, R> Function2<T1, T2, R> untupled(Function1<Tuple2<T1, T2>, R> f) {
        return (x1, x2) -> f.apply(Tuple.of(x1, x2));
    }

    static <T1, T2, R> Function2<T1, T2, R> uncurried(Function1<T1, Function1<T2, R>> f) {
        return (x1, x2) -> f.apply(x1).apply(x2);
    }

}
