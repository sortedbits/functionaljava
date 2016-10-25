package com.sortedbits.functionaljava.suppliers;

import com.sortedbits.functionaljava.functions.CheckedFunction1;

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

    static <T, R> CheckedSupplier<R> checkedSupplier(CheckedFunction1<T, R> f, final T x) {
        return () -> f.apply(x);
    }
}
