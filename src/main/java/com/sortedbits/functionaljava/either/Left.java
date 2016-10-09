package com.sortedbits.functionaljava.either;

import static java.util.Optional.empty;
import static java.util.Optional.ofNullable;

public class Left<A, B> extends Either<A, B> {
	
	Left(A a) {
		left = ofNullable(a);
		right = empty();
	}

	@Override
	public boolean isRight() {
		return false;
	}

	@Override
	public boolean isLeft() {
		return true;
	}
	
}
