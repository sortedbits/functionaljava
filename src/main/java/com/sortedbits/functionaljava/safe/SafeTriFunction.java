package com.sortedbits.functionaljava.safe;

import com.sortedbits.functionaljava.TriFunction;
import com.sortedbits.functionaljava.either.Either;

@FunctionalInterface
public interface SafeTriFunction<A, B, C, D> extends TriFunction<A, B, C, Either<Exception, D>>{
	
	@Override
	default Either<Exception, D> apply(A a, B b, C c) {
		try {
			return Either.right(applyThrows(a, b, c));
		} catch (Exception e) {
			return Either.left(e);
		}		
	}
	
	D applyThrows(A a, B b, C c) throws Exception;

}
