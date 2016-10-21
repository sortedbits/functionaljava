package com.sortedbits.functionaljava.functions;

import com.sortedbits.functionaljava.Arity;
import com.sortedbits.functionaljava.tuples.Unit;

public interface Function extends Arity {

    static <R> Function0<R> function0(java.util.function.Supplier<R> s) {
        return s::get;
    }

	static <T, R> Function1<T, R> function1(java.util.function.Function<T, R> f) {
		return f::apply;
	}

	static <T> Function1<T, Unit> function1(java.util.function.Consumer<T> c) {
		return x -> {
			c.accept(x);
			return Unit.UNIT;
		};
	}
}
