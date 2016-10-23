package com.sortedbits.functionaljava.suppliers;

import com.sortedbits.functionaljava.functions.Function0;
import com.sortedbits.functionaljava.functions.Function1;

@FunctionalInterface
public interface Supplier0 extends Supplier, java.util.function.Supplier<Void> {

    Void get();
    
    default int arity() {
    	return 0;
    }
    
    default Function0<Void> function0() {
        return () -> get();
    }
    
    default <T> Function1<T, Void> function1(java.util.function.Consumer<T> c) {
        return (T x) -> {
            c.accept(x);
            return get();
        };
    }    
}
