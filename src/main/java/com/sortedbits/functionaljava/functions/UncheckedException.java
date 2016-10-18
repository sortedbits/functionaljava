package com.sortedbits.functionaljava.functions;

public class UncheckedException extends RuntimeException {

    UncheckedException(Exception e) {
        super(e);
    }
}
