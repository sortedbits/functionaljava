package com.sortedbits.functionaljava.tuples;

import java.util.Objects;

public class Tuple1<T1> implements Tuple {

    public final T1 _1;

    protected Tuple1(T1 _1) {
        this._1 = _1;
    }

    @Override
    public final int arity() {
        return 1;
    }

    @Override
    public int hashCode() {
        return Objects.hash(_1);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Tuple1)) {
            return false;
        }
        final Tuple1<?> that = (Tuple1<?>) obj;
        return Objects.equals(_1, that._1);
    }

    @Override
    public String toString() {
        return String.format("(%s)", _1);
    }
}