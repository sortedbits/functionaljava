package com.sortedbits.functionaljava.either;

import static java.util.Optional.empty;
import static java.util.Optional.ofNullable;

public class Right<A, B> extends Either<A, B> {

	Right(B b) {
		left = empty();
		right = ofNullable(b);
	}

	@Override
	public boolean isRight() {
		return true;
	}

	@Override
	public boolean isLeft() {
		return false;
	}

}
