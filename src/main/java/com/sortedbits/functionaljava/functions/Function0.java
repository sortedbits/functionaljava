package com.sortedbits.functionaljava.functions;

@FunctionalInterface
public interface Function0<R> extends Function {

    R apply();

    default int arity() {
        return 0;
    }

}
