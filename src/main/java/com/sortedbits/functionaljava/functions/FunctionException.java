package com.sortedbits.functionaljava.functions;

public class FunctionException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    protected FunctionException(Exception error) {
        super(error);
    }
}
