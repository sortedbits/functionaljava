package com.sortedbits.functionaljava.functions;

import com.sortedbits.functionaljava.UncheckedException;

public class FunctionException extends UncheckedException {

    private static final long serialVersionUID = 1L;

    protected FunctionException(Exception error) {
        super(error);
    }
}
