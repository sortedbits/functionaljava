package com.sortedbits.functionaljava.suppliers;

@FunctionalInterface
public interface CheckedSupplier<T> extends Supplier<T> {

    T getThrows() throws Exception;

    default T get() {
        try {
            return getThrows();
        } catch (Exception error) {
            throw new SupplierException(error);
        }
    }
}
