package com.sortedbits.functionaljava.consumers;

import com.sortedbits.functionaljava.tuples.Tuple;
import com.sortedbits.functionaljava.tuples.Tuple3;

@FunctionalInterface
public interface Consumer3<T1, T2, T3> extends Consumer {

    void accept(T1 x1, T2 x2, T3 x3);

    default int arity() {
        return 3;
    }

    default Consumer1<Tuple3<T1, T2, T3>> tuple() {
        return t -> accept(t._1, t._2, t._3);
    }

    static <T1, T2, T3> Consumer3<T1, T2, T3> untuple(java.util.function.Consumer<Tuple3<T1, T2, T3>> c) {
        return (x1, x2, x3) -> c.accept(Tuple.of(x1, x2, x3));
    }
}
