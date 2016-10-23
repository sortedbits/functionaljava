package com.sortedbits.functionaljava.suppliers;

import com.sortedbits.functionaljava.consumers.Consumer1;
import com.sortedbits.functionaljava.functions.Function0;
import com.sortedbits.functionaljava.functions.Function1;

@FunctionalInterface
public interface Supplier1<R> extends Supplier, java.util.function.Supplier<R> {

    R get();
    
    default int arity() {
    	return 0;
    }
    
    default <T> Function1<T, R> function1() {
        return function1(Consumer1.nop());
    }
    
    default <T> Function1<T, R> function1(java.util.function.Consumer<T> c) {
        return (T x) -> {
            c.accept(x);
            return get();
        };
    }

    default Function0<R> function0() {
        return this::get;
    }    
}
