<<<<<<< HEAD
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
=======
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
>>>>>>> 4f382b8fb3b31eddc0cfeabac1f0432cd6b18d2c
