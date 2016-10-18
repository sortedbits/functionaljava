package com.sortedbits.functionaljava.tuples;

import java.util.Objects;

public class Tuple2<T1, T2> implements Tuple {

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