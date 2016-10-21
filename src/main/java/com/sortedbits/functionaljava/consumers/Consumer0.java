package com.sortedbits.functionaljava.consumers;

public interface Consumer0 extends Consumer {

    void accept();

    default int arity() {
        return 0;
    }

}
