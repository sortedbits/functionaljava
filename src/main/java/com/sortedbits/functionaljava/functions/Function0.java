package com.sortedbits.functionaljava.functions;

import static com.sortedbits.functionaljava.tuples.Tuple.UNIT;
import com.sortedbits.functionaljava.tuples.Tuple0;

@FunctionalInterface
public interface Function0<R> extends Function {

    R apply();

    default int arity() {
        return 0;
    }
    
    default Function1<Tuple0, R> tuple() {
        return x -> this.apply();
    }

    static <R> Function0<R> untuple(java.util.function.Function<Tuple0, R> f) {
        return () -> f.apply(UNIT);
    }
}
