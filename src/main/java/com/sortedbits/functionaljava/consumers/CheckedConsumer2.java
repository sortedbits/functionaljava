package com.sortedbits.functionaljava.consumers;

public interface CheckedConsumer2<T1, T2> extends Consumer2<T1, T2> {

    void acceptThrows(T1 x1, T2 x2) throws Exception;

    @Override
    default void accept(T1 x1, T2 x2) {
        try {
            acceptThrows(x1, x2);
        } catch (Exception error) {
            throw new ConsumerException(error);
        }
    }
}
