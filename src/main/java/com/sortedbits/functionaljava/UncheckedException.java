package com.sortedbits.functionaljava;

public class UncheckedException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	protected UncheckedException(Exception error) {
        super(error);
    }
}
