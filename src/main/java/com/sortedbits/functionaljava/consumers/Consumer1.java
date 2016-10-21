package com.sortedbits.functionaljava.consumers;

import com.sortedbits.functionaljava.tuples.Tuple;
import com.sortedbits.functionaljava.tuples.Tuple1;

import java.util.List;

@FunctionalInterface
public interface Consumer1<T> extends Consumer, java.util.function.Consumer<T> {

    Consumer1 NOP = x -> {};

    static <T> Consumer1<T> nop() {
        return (Consumer1<T>)NOP;
    }

    void accept(T x);

    default int arity() {
        return 1;
    }

    default Consumer1<Tuple1<T>> tuple() {
        return t -> accept(t._1);
    }

    static <T> Consumer1<T> untuple(Consumer1<Tuple1<T>> c) {
        return x -> c.accept(Tuple.of(x));
    }
}

