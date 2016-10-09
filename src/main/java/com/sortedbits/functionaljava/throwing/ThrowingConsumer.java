package com.sortedbits.functionaljava.throwing;

import java.util.function.Consumer;

@FunctionalInterface
public interface ThrowingConsumer<A> extends Consumer<A> {

	@Override
	default void accept(A arg) {
		try {
			acceptThrows(arg);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	void acceptThrows(A arg) throws Exception;
	
}
