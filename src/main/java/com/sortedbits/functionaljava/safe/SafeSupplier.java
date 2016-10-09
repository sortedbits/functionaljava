package com.sortedbits.functionaljava.safe;

import java.util.function.Supplier;

import com.sortedbits.functionaljava.either.Either;

@FunctionalInterface
public interface SafeSupplier<A> extends Supplier<Either<Exception, A>> {

	@Override
	default Either<Exception, A> get() {
		try {
			return Either.right(getThrows());
		} catch (Exception e) {
			return Either.left(e);
		}
	}

	A getThrows() throws Exception;
	
}
