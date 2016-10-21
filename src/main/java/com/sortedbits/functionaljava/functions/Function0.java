package com.sortedbits.functionaljava.functions;

import com.sortedbits.functionaljava.tuples.Unit;

@FunctionalInterface
public interface Function0<R> extends Function {

    R apply();

    default int arity() {
        return 0;
    }
    
    default Function1<Unit, R> tuple() {
        return x -> this.apply();
    }

    static <R> Function0<R> untuple(java.util.function.Function<Unit, R> f) {
        return () -> f.apply(Unit.UNIT);
    }
}
