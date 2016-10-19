package com.sortedbits.functionaljava;

public interface Try<T> {

    class Success<T> implements Try<T> {
        final T value;

        private Success(T value) {
            this.value = value;
        }
    }

    class Failure implements Try<Throwable> {
        final Throwable exception;

        private Failure(Throwable exception) {
            this.exception = exception;
        }
    }

    static <T> Success<T> success(T value) {
        return new Success<>(value);
    }

    static Failure failure(Throwable exception) {
        return new Failure(exception);
    }


}
