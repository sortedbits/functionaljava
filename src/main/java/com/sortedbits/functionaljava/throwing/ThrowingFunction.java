package com.sortedbits.functionaljava.throwing;

import java.util.function.Function;

@FunctionalInterface
public interface ThrowingFunction<A, B> extends Function<A, B> {
	
	@Override
	default B apply(A arg) {
		try {
			return applyThrows(arg);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}		
	}
	
	B applyThrows(A arg) throws Exception;
		
}
