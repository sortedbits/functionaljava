package com.sortedbits.functionaljava.consumers;

import com.sortedbits.functionaljava.functions.Function2;

@FunctionalInterface
public interface Consumer2<T1, T2> extends Consumer, Function2<T1, T2, Void> {

    default int arity() {
        return 2;
    }

    void accept(T1 x1, T2 x2);

    default Void apply(T1 x1, T2 x2) {
        accept(x1, x2);
        return null;
    }

}
