package com.sortedbits.functionaljava.predicates;

import com.sortedbits.functionaljava.functions.FunctionException;

public class PredicateException extends FunctionException {

    private static final long serialVersionUID = 1L;

    protected PredicateException(Exception error) {
        super(error);
    }
}
