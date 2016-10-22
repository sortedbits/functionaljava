package com.sortedbits.functionaljava.suppliers;

import com.sortedbits.functionaljava.Arity;
import com.sortedbits.functionaljava.consumers.Consumer1;
import com.sortedbits.functionaljava.functions.Function0;
import com.sortedbits.functionaljava.functions.Function1;

@FunctionalInterface
public interface Supplier<R> extends Arity, java.util.function.Supplier<R> {

    @Override R get();

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
    

    static <T> Supplier<T> supplier1(Function0<T> f) {
        return f::apply;
    }

    static <T> Supplier<T> supplier1(java.util.function.Supplier<T> s) {
        return s::get;
    }
}
