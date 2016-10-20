package com.sortedbits.functionaljava.consumers;


public interface Consumer0 extends Consumer {

    default int arity() {
        return 0;
    }

    void accept();

}
