package com.sortedbits.functionaljava.safe;

import java.util.function.Function;

import com.sortedbits.functionaljava.either.Either;

@FunctionalInterface
public interface SafeFunction<A, B> extends Function<A, Either<Exception, B>>{
	
	@Override
	default Either<Exception, B> apply(A arg) {
		try {
			return Either.right(applyThrows(arg));
		} catch (Exception e) {
			return Either.left(e);
		}		
	}
	
	B applyThrows(A arg) throws Exception;

}
