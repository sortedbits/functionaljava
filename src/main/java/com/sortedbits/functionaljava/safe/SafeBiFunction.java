package com.sortedbits.functionaljava.safe;

import java.util.function.BiFunction;

import com.sortedbits.functionaljava.either.Either;

@FunctionalInterface
public interface SafeBiFunction<A, B, C> extends BiFunction<A, B, Either<Exception, C>>{
	
	@Override
	default Either<Exception, C> apply(A a, B b) {
		try {
			return Either.right(applyThrows(a, b));
		} catch (Exception e) {
			return Either.left(e);
		}		
	}
	
	C applyThrows(A a, B b) throws Exception;

}
