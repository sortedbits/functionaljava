package com.sortedbits.functionaljava.consumers;

import static com.sortedbits.functionaljava.tuples.Tuple.UNIT;

import com.sortedbits.functionaljava.tuples.Tuple0;

@FunctionalInterface
public interface Consumer0 extends Consumer {

    void accept();

    default int arity() {
        return 0;
    }

    default Consumer1<Tuple0> tuple() {
        return t -> accept();
    }

    static Consumer0 untuple(Consumer1<Tuple0> c) {
        return () -> c.accept(UNIT);
    }
}
