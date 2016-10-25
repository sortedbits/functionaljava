package com.sortedbits.functionaljava;

import static com.sortedbits.functionaljava.Try.getError;
import static com.sortedbits.functionaljava.Try.getValue;
import static java.util.Optional.empty;
import static java.util.Optional.ofNullable;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Function;

public abstract class Either<L, R> {

    protected Optional<L> left;
    protected Optional<R> right;

    protected Either() {
    }

    public abstract boolean isRight();

    public abstract boolean isLeft();

    public L getLeft() {
        return left.orElseThrow(() -> new NoSuchElementException("Right.getLeft"));
    }

    public R getRight() {
        return right.orElseThrow(() -> new NoSuchElementException("Left.getRight"));
    }

    public <V> Either<L, V> map(Function<? super R, ? extends V> f) {
        if (!right.isPresent()) {
            return left(getLeft());
        } else {
            return right(f.apply(getRight()));
        }
    }

    public <V> Either<L, V> flatMap(Function<? super R, Either<L, V>> f) {
        if (!right.isPresent()) {
            return left(getLeft());
        } else {
            return f.apply(getRight());
        }
    }

    public static <R> Either<Throwable, R> either(Try<R> t) {
        if (t.isSuccess()) {
            return right(getValue(t));
        } else {
            return left(getError(t));
        }
    }

    public static <L, R> Left<L, R> left(L x) {
        return new Left<>(x);
    }

    public static <L, R> Right<L, R> right(R x) {
        return new Right<>(x);
    }

    public static class Left<L, R> extends Either<L, R> {

        Left(L x) {
            left = ofNullable(x);
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

    public static class Right<L, R> extends Either<L, R> {

        Right(R x) {
            left = empty();
            right = ofNullable(x);
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
