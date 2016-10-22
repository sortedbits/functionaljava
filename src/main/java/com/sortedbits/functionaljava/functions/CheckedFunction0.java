package com.sortedbits.functionaljava.functions;

@FunctionalInterface
public interface CheckedFunction0<R> extends Function0<R> {

    R applyThrows() throws Exception;

    @Override
    default R apply() {
        try {
            return applyThrows();
        } catch (Exception e) {
            throw new FunctionException(e);
        }
    }
}