package com.sortedbits.functionaljava.consumers;

import com.sortedbits.functionaljava.commons.UncheckedException;

public interface CheckedConsumer1<T> extends Consumer {

    void accept(T x) throws Exception;

    default Consumer1<T> unchecked() {
        return x -> {
            try {
                accept(x);
            } catch (Exception e) {
                throw new UncheckedException(e);
            }
        };
    }
}
