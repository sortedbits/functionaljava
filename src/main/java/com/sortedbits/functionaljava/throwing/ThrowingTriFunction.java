package com.sortedbits.functionaljava.throwing;

import com.sortedbits.functionaljava.TriFunction;

@FunctionalInterface
public interface ThrowingTriFunction<A, B, C, D> extends TriFunction<A, B, C, D> {
	
	@Override
	default D apply(A a, B b, C c) {
		try {
			return applyThrows(a, b, c);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}		
	}
	
	D applyThrows(A a, B b, C c) throws Exception;
		
}
