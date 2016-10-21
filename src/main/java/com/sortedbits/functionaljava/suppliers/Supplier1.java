package com.sortedbits.functionaljava.suppliers;

import com.sortedbits.functionaljava.consumers.Consumer1;
import com.sortedbits.functionaljava.functions.Function0;

@FunctionalInterface
public interface Supplier1<R> extends Supplier, java.util.function.Supplier<R> {

    default int arity() {
        return 1;
    }

    default <T> java.util.function.Function<T, R> function() {
        return function(Consumer1.nop());
    }

    default <T> java.util.function.Function<T, R> function(Consumer1<T> c) {
        return (T x) -> {
            c.accept(x);
            return get();
        };
    }

    default Function0<R> function0() {
        return this::get;
    }

}
