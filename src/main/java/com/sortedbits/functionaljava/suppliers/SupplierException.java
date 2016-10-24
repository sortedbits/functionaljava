package com.sortedbits.functionaljava.suppliers;

import com.sortedbits.functionaljava.functions.FunctionException;

public class SupplierException extends FunctionException {

    private static final long serialVersionUID = 1L;

    protected SupplierException(Exception error) {
        super(error);
    }
}
