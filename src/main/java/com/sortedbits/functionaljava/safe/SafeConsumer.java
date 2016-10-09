package com.sortedbits.functionaljava.safe;

import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;

@FunctionalInterface
public interface SafeConsumer<A> extends Consumer<A> {

	@Override
	default void accept(A arg) {
		try {
			acceptThrows(arg);
		} catch (Exception e) {
			onError(e);
		}
	}

	default void onError(Exception e) {
		Logger.getLogger(getClass().getName()).log(Level.SEVERE, "SafeConsumer.onError", e);
	}

	void acceptThrows(A arg) throws Exception;
	
}
