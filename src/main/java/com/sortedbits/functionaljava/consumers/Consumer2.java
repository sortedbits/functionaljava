package com.sortedbits.functionaljava.consumers;

import com.sortedbits.functionaljava.tuples.Tuple;
import com.sortedbits.functionaljava.tuples.Tuple2;

import java.util.function.BiConsumer;

@FunctionalInterface
public interface Consumer2<T1, T2> extends Consumer, BiConsumer<T1, T2> {

    void accept(T1 x1, T2 x2);

    default int arity() {
        return 2;
    }

    default Consumer1<Tuple2<T1, T2>> tuple() {
        return t -> accept(t._1, t._2);
    }

    static <T1, T2> Consumer2<T1, T2> untuple(java.util.function.Consumer<Tuple2<T1, T2>> c) {
        return (x1, x2) -> c.accept(Tuple.of(x1, x2));
    }
}
