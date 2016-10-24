package com.sortedbits.functionaljava.consumers;

public interface CheckedConsumer1<T> extends Consumer1<T> {

    void acceptThrows(T x) throws Exception;

    @Override
    default void accept(T x) {
        try {
            acceptThrows(x);
        } catch (Exception error) {
            throw new ConsumerException(error);
        }
    }
}
