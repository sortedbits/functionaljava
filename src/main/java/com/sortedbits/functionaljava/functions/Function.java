package com.sortedbits.functionaljava.functions;

import static com.sortedbits.functionaljava.tuples.Tuple.UNIT;

import java.util.function.BiFunction;

import com.sortedbits.functionaljava.Arity;
import com.sortedbits.functionaljava.consumers.Consumer2;
import com.sortedbits.functionaljava.consumers.Consumer3;
import com.sortedbits.functionaljava.tuples.Tuple0;

public interface Function extends Arity {

	static <R> Function0<R> function0(java.util.function.Supplier<R> s) {
		return s::get;
	}

	static <T> Function1<T, Tuple0> function1(java.util.function.Consumer<T> c) {
		return x -> {
			c.accept(x);
			return UNIT;
		};
	}

	static <T, R> Function1<T, R> function1(java.util.function.Function<T, R> f) {
		return f::apply;
	}

	static <T1, T2, R> Function2<T1, T2, R> function2(BiFunction<T1, T2, R> f) {
		return (x1, x2) -> f.apply(x1, x2);
	}
	
	static <T1, T2> Function2<T1, T2, Tuple0> function2(Consumer2<T1, T2> c) {
		return (x1, x2) -> {
			c.accept(x1, x2);
			return UNIT;
		};
	}
	
	static <T1, T2, T3> Function3<T1, T2, T3, Tuple0> function3(Consumer3<T1, T2, T3> c) {
		return (x1, x2, x3) -> {
			c.accept(x1, x2, x3);
			return UNIT;
		};
	}
}
