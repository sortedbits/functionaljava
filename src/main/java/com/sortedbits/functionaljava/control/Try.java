package com.sortedbits.functionaljava.control;

import java.util.NoSuchElementException;
import java.util.function.Supplier;

public interface Try<R> {

    final class Success<R> implements Try<R> {
        public final R value;

        @Override
        public boolean isSuccess() {
            return true;
        }

        @Override
        public boolean isFailure() {
            return false;
        }

        private Success(R value) {
            this.value = value;
        }
    }

    final class Failure<R> implements Try<R> {
        public final Throwable error;

        @Override
        public boolean isSuccess() {
            return false;
        }

        @Override
        public boolean isFailure() {
            return true;
        }

        private Failure(Throwable error) {
            this.error = error;
        }
    }

    boolean isSuccess();

    boolean isFailure();

    static <R> Success<R> success(R value) {
        return new Success<>(value);
    }

    static <R> Failure<R> failure(Throwable error) {
        return new Failure<>(error);
    }

    static <R> R getValue(Try<R> t) {
        if (t.isSuccess()) {
            Success<R> x = (Success<R>)t;
            return x.value;
        } else {
            throw new NoSuchElementException("Error.getValue");
        }
    }

    static <R> Throwable getError(Try<R> t) {
        if (t.isFailure()) {
            Failure<R> x = (Failure<R>)t;
            return x.error;
        } else {
            throw new NoSuchElementException("Success.getError");
        }
    }

    static <R> Try<R> of(Supplier<R> supplier) {
        try {
            return new Success<>(supplier.get());
        } catch (Throwable error) {
            return new Failure<>(error);
        }
    }

    static Try<Void> of(Runnable runnable) {
        try {
            runnable.run();
            return new Success<>(null);
        } catch (Throwable error) {
            return new Failure<>(error);
        }
    }
}
