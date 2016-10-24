package com.sortedbits.functionaljava.functions;

import com.sortedbits.functionaljava.tuples.Tuple;
import com.sortedbits.functionaljava.tuples.Tuple2;

import java.util.Objects;
import java.util.function.BiFunction;

@FunctionalInterface
public interface Function2<T1, T2, R> extends BiFunction<T1, T2, R>, Function {

    @Override R apply(T1 x1, T2 x2);

    default int arity() {
        return 2;
    }

    default Function1<Tuple2<T1, T2>, R> tuple() {
        return t -> this.apply(t._1, t._2);
    }

    default Function1<T1, Function1<T2, R>> curry() {
        return x1 -> x2 -> apply(x1, x2);
    }

    default Function1<T2, R> apply(T1 x1) {
        return x2 -> apply(x1, x2);
    }

    default <V> Function2<T1, T2, V> andThen(java.util.function.Function<? super R, ? extends V> after) {
        return (T1 x1, T2 x2) -> after.apply(apply(x1, x2));
    }

    static <T1, T2, R> Function2<T1, T2, R> untuple(java.util.function.Function<Tuple2<T1, T2>, R> f) {
        return (x1, x2) -> f.apply(Tuple.of(x1, x2));
    }

    static <T1, T2, R> Function2<T1, T2, R> uncurry(java.util.function.Function<T1, java.util.function.Function<T2, R>> f) {
        return (x1, x2) -> f.apply(x1).apply(x2);
    }


}
