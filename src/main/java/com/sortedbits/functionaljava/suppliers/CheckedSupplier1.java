package com.sortedbits.functionaljava.suppliers;

@FunctionalInterface
public interface CheckedSupplier1<R> extends Supplier1<R> {

    R getThrows() throws Exception;

    default R get() {
        try {
            return getThrows();
        } catch (Exception error) {
            throw new SupplierException(error);
        }
    }
}
