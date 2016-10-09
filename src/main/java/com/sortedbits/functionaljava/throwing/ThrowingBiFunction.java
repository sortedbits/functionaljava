package com.sortedbits.functionaljava.throwing;

import java.util.function.BiFunction;

@FunctionalInterface
public interface ThrowingBiFunction<A, B, C> extends BiFunction<A, B, C> {
	
	@Override
	default C apply(A a, B b) {
		try {
			return applyThrows(a, b);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}		
	}
	
	C applyThrows(A a, B b) throws Exception;
		
}
