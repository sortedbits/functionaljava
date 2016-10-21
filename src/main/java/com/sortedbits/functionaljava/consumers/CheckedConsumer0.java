package com.sortedbits.functionaljava.consumers;

public interface CheckedConsumer0 extends Consumer0 {

    void acceptThrows() throws Exception;

    @Override
    default void accept() {
        try {
            acceptThrows();
        } catch (Exception error) {
            throw new ConsumerException(error);
        }
    }
}
