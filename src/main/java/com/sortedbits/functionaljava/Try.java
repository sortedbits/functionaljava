package com.sortedbits.functionaljava;

import java.util.function.Supplier;

import com.sortedbits.functionaljava.functions.Function0;

public interface Try<R> {

    final class Success<R> implements Try<R> {
        final R value;

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

    static <R> Success<R> success(R value) {
        return new Success<>(value);
    }

    static <R> Failure<R> failure(Throwable error) {
        return new Failure<>(error);
    }

    static <R> Try<R> of(Supplier<R> supplier) {
        try {
            return new Success<>(supplier.get());
        } catch (Throwable error) {
            return new Failure<>(error);
        }
    }
    
    static <R> Try<R> of(Function0<R> f) {
        try {
            return new Success<>(f.apply());
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
