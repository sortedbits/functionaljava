package com.sortedbits.functionaljava.tuples;

import java.util.Objects;

public class Tuple6<T1, T2, T3, T4, T5, T6> implements Tuple {

    public final T1 _1;
    public final T2 _2;
    public final T3 _3;
    public final T4 _4;
    public final T5 _5;
    public final T6 _6;

    protected Tuple6(T1 _1, T2 _2, T3 _3, T4 _4, T5 _5, T6 _6) {
        this._1 = _1;
        this._2 = _2;
        this._3 = _3;
        this._4 = _4;
        this._5 = _5;
        this._6 = _6;
    }

    @Override
    public final int arity() {
        return 6;
    }

    @Override
    public int hashCode() {
        return Objects.hash(_1, _2, _3, _4, _5, _6);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Tuple6)) {
            return false;
        }
        final Tuple6<?, ?, ?, ?, ?, ?> that = (Tuple6<?, ?, ?, ?, ?, ?>) obj;
        return Objects.equals(_1, that._1) && Objects.equals(_2, that._2) && Objects.equals(_3, that._3) && Objects.equals(_4, that._4) && Objects.equals(_5, that._5) && Objects.equals(_6, that._6);
    }

    @Override
    public String toString() {
        return String.format("(%s, %s, %s, %s, %s, %s)", _1, _2, _3, _4, _5, _6);
    }
}
