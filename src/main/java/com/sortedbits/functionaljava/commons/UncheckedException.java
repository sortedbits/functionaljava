package com.sortedbits.functionaljava.commons;

public class UncheckedException extends RuntimeException {

    public UncheckedException(Exception e) {
        super(e);
    }

}
