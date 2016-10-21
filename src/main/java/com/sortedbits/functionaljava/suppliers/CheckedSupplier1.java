package com.sortedbits.functionaljava.suppliers;

import com.sortedbits.functionaljava.commons.UncheckedException;

@FunctionalInterface
public interface CheckedSupplier1<T> extends Supplier {

    default int arity() {
        return 1;
    }

    T get() throws Exception;

    default Supplier1<T> unchecked() {
        return () -> {
            try {
                return get();
            } catch (Exception e) {
                throw new UncheckedException(e);
            }
        };
    }
}
