package com.sortedbits.functionaljava.consumers;

public interface CheckedConsumer3<T1, T2, T3> extends Consumer3<T1, T2, T3> {

    void acceptThrows(T1 x1, T2 x2, T3 x3) throws Exception;

    @Override
    default void accept(T1 x1, T2 x2, T3 x3) {
        try {
            acceptThrows(x1, x2, x3);
        } catch (Exception error) {
            throw new ConsumerException(error);
        }
    }
}
