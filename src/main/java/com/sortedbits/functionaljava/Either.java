package com.sortedbits.functionaljava;

import static java.util.Optional.empty;
import static java.util.Optional.ofNullable;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Function;

public abstract class Either<A, B> {

	protected Optional<A> left;
	protected Optional<B> right;

	protected Either() {
	}

	public abstract boolean isRight();

	public abstract boolean isLeft();

	public A getLeft() {
		return left.orElseThrow(() -> new NoSuchElementException("Right.getLeft"));
	}

	public B getRight() {
		return right.orElseThrow(() -> new NoSuchElementException("Left.getRight"));
	}

	public <C> Either<A, C> map(Function<? super B, ? extends C> f) {
		if (!right.isPresent()) {
			return left(getLeft());
		} else {
			return right(f.apply(getRight()));
		}
	}

	public <C> Either<A, C> flatMap(Function<? super B, Either<A, C>> f) {
		if (!right.isPresent()) {
			return left(getLeft());
		} else {
			return f.apply(getRight());
		}
	}

	public static <A, B> Left<A, B> left(A a) {
		return new Left<>(a);
	}

	public static <A, B> Right<A, B> right(B b) {
		return new Right<>(b);
	}

	public static class Left<A, B> extends Either<A, B> {

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
	
	public static class Right<A, B> extends Either<A, B> {

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
}
