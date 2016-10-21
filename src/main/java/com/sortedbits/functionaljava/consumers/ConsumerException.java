package com.sortedbits.functionaljava.consumers;

import com.sortedbits.functionaljava.functions.FunctionException;

public class ConsumerException extends FunctionException {

    private static final long serialVersionUID = 1L;

    protected ConsumerException(Exception error) {
        super(error);
    }
}
