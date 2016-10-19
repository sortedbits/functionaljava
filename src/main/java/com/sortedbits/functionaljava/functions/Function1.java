package com.sortedbits.functionaljava.functions;

import com.sortedbits.functionaljava.tuples.Tuple;
import com.sortedbits.functionaljava.tuples.Tuple1;

import java.util.function.Function;

@FunctionalInterface
public interface Function1<T1, R> extends Function<T1, R> {

    R apply(T1 x1);

    default Function1<Tuple1<T1>, R> tupled() {
        return t -> this.apply(t._1);
    }

    static <T1, R> Function1<T1, R> untupled(Function1<Tuple1<T1>, R> f) {
        return (x1) -> f.apply(Tuple.of(x1));
    }
}
