package com.sortedbits.functionaljava.tuples;

import java.util.Map;
import java.util.Objects;

public class Tuple2<T1, T2> implements Tuple, Map.Entry<T1, T2> {

    private static final long serialVersionUID = 1L;

    public final T1 _1;
    public final T2 _2;

    protected Tuple2(T1 _1, T2 _2) {
        this._1 = _1;
        this._2 = _2;
    }

    @Override
    public final int arity() {
        return 2;
    }

    @Override
    public T1 getKey() {
        return _1;
    }

    @Override
    public T2 getValue() {
        return _2;
    }

    @Override
    public T2 setValue(T2 value) {
        throw new UnsupportedOperationException("Tuple2.setValue");
    }

    @Override
    public int hashCode() {
        return Objects.hash(_1, _2);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Tuple2)) {
            return false;
        }
        final Tuple2<?, ?> that = (Tuple2<?, ?>) obj;
        return Objects.equals(_1, that._1) && Objects.equals(_2, that._2);
    }

    @Override
    public String toString() {
        return String.format("(%s, %s)", _1, _2);
    }
}
