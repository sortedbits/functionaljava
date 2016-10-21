package com.sortedbits.functionaljava.functions;

import com.sortedbits.functionaljava.commons.UncheckedException;
import com.sortedbits.functionaljava.tuples.Tuple;
import com.sortedbits.functionaljava.tuples.Tuple1;

@FunctionalInterface
public interface Function1<T, R> extends java.util.function.Function<T, R>, Function {

    @Override R apply(T x);

    default int arity() {
        return 1;
    }

    default Function1<Tuple1<T>, R> tuple() {
        return t -> this.apply(t._1);
    }

    static <T, R> Function1<T, R> untuple(Function1<Tuple1<T>, R> f) {
        return x -> f.apply(Tuple.of(x));
    }


}
