package com.sortedbits.functionaljava.consumers;

import com.sortedbits.functionaljava.Arity;
import com.sortedbits.functionaljava.functions.Function0;
import com.sortedbits.functionaljava.functions.Function1;

public interface Consumer extends Arity {
	
    static <R> Consumer0 consumer0(Function0<R> f) {
        return consumer0(f, Consumer1.nop());
    }

    static <R> Consumer0 consumer0(Function0<R> f, java.util.function.Consumer<R> c) {
        return () -> c.accept(f.apply());
    }

    static <T, R> java.util.function.Consumer<T> consumer(java.util.function.Function<T, R> f) {
        return consumer(f, Consumer1.nop());
    }

    static <T, R> java.util.function.Consumer<T> consumer(java.util.function.Function<T, R> f, java.util.function.Consumer<R> c) {
        return x -> c.accept(f.apply(x));
    }

    static <T, R> Consumer1<T> consumer1(Function1<T, R> f) {
        return consumer1(f, Consumer1.nop());
    }

    static <T, R> Consumer1<T> consumer1(java.util.function.Function<T, R> f, java.util.function.Consumer<R> c) {
        return x -> c.accept(f.apply(x));
    }
}
