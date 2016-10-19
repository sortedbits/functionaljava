package com.sortedbits.functionaljava.consumers;

public interface CheckedConsumer1<T> extends Consumer {

    void accept(T x) throws Exception;

}
