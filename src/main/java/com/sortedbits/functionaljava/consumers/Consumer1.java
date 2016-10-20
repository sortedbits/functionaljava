package com.sortedbits.functionaljava.consumers;

import com.sortedbits.functionaljava.functions.Function1;

@FunctionalInterface
public interface Consumer1<T> extends Consumer, java.util.function.Consumer<T> {

    default int arity() {
        return 1;
    }

    void accept(T x);

}

