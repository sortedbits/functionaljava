package com.sortedbits.functionaljava.consumers;

import com.sortedbits.functionaljava.commons.Arity;
import com.sortedbits.functionaljava.functions.Function0;
import com.sortedbits.functionaljava.functions.Function1;

public interface Consumer extends Arity {

    static <R> Consumer0 consumer0(Function0<R> f) {
        return consumer0(f, Consumer1.nop());
    }

    static <R> Consumer0 consumer0(Function0<R> f, Consumer1<R> c) {
        return () -> c.accept(f.apply());
    }

    static <T, R> Consumer1<T> consumer1(Function1<T, R> f) {
        return consumer1(f, Consumer1.nop());
    }

    static <T, R> Consumer1<T> consumer1(Function1<T, R> f, Consumer1<R> c) {
        return x -> c.accept(f.apply(x));
    }
}
