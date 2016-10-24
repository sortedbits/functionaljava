package com.sortedbits.functionaljava.suppliers;

@FunctionalInterface
public interface CheckedSupplier<R> extends Supplier<R> {

    R getThrows() throws Exception;

    default R get() {
        try {
            return getThrows();
        } catch (Exception error) {
            throw new SupplierException(error);
        }
    }
}
