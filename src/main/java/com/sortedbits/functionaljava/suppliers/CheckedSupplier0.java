package com.sortedbits.functionaljava.suppliers;

@FunctionalInterface
public interface CheckedSupplier0 extends Supplier0 {

    Void getThrows() throws Exception;

    default Void get() {
        try {
            return getThrows();
        } catch (Exception error) {
            throw new SupplierException(error);
        }
    }
}
