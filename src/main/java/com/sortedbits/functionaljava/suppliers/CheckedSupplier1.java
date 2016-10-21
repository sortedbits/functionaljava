package com.sortedbits.functionaljava.suppliers;

@FunctionalInterface
public interface CheckedSupplier1<T> extends Supplier1<T> {

    T getThrows() throws Exception;

    default T get() {
        try {
            return getThrows();
        } catch (Exception error) {
            throw new SupplierException(error);
        }
    }
}
