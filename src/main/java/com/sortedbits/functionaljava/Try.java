package com.sortedbits.functionaljava;

import java.util.function.Supplier;

public interface Try<T> {

    final class Success<T> implements Try<T> {
        final T value;

        @Override
        public boolean isSuccess() {
            return true;
        }

        @Override
        public boolean isFailure() {
            return false;
        }

        private Success(T value) {
            this.value = value;
        }
    }

    final class Failure<T> implements Try<T> {
        final Throwable error;

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

    static <T> Success<T> success(T value) {
        return new Success<>(value);
    }

    static <T> Failure<T> failure(Throwable error) {
        return new Failure<>(error);
    }

    static <T> Try<T> of(Supplier<T> supplier) {
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
