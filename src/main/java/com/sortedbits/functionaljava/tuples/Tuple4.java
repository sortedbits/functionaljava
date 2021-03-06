package com.sortedbits.functionaljava.tuples;

import java.util.Objects;

public class Tuple4<T1, T2, T3, T4> implements Tuple {

    private static final long serialVersionUID = 1L;

    public final T1 _1;
    public final T2 _2;
    public final T3 _3;
    public final T4 _4;

    protected Tuple4(T1 _1, T2 _2, T3 _3, T4 _4) {
        this._1 = _1;
        this._2 = _2;
        this._3 = _3;
        this._4 = _4;
    }

    @Override
    public final int arity() {
        return 4;
    }

    @Override
    public int hashCode() {
        return Objects.hash(_1, _2, 3, _4);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Tuple4)) {
            return false;
        }
        final Tuple4<?, ?, ?, ?> that = (Tuple4<?, ?, ?, ?>) obj;
        return Objects.equals(_1, that._1) && Objects.equals(_2, that._2) && Objects.equals(_3, that._3) && Objects.equals(_4, that._4);
    }

    @Override
    public String toString() {
        return String.format("(%s, %s, %s, %s)", _1, _2, _3, _4);
    }
}
