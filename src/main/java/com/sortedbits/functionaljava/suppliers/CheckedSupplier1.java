package com.sortedbits.functionaljava.suppliers;

import com.sortedbits.functionaljava.commons.UncheckedException;
import com.sortedbits.functionaljava.consumers.Consumer1;

@FunctionalInterface
public interface CheckedSupplier1<T> extends Supplier {

    default int arity() {
        return 1;
    }

    T get() throws Exception;

    default Supplier1<T> unchecked() {
        return unchecked(error -> { throw new UncheckedException(error); });
    }

    default Supplier1<T> unchecked(Consumer1<Exception> handler) {

        return new Supplier1<T>() {
            @Override
            public T get() {
                try {
                    return get();
                } catch (Exception error) {
                    handler.accept(error);
                    return null;
                }
            }
        };
    }
}
