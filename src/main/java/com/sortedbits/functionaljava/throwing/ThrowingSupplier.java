package com.sortedbits.functionaljava.throwing;

import java.util.function.Supplier;

@FunctionalInterface
public interface ThrowingSupplier<A> extends Supplier<A> {

	@Override
	default A get() {
		try {
			return getThrows();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	A getThrows() throws Exception;
	
}
