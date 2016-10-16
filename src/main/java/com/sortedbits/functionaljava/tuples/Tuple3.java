package com.sortedbits.functionaljava.tuples;

import java.util.Objects;

public class Tuple3<T1, T2, T3> implements Tuple {

    public final T1 _1;
    public final T2 _2;
    public final T3 _3;

    protected Tuple3(T1 _1, T2 _2, T3 _3) {
        this._1 = _1;
        this._2 = _2;
        this._3 = _3;
    }

    @Override
    public final int arity() {
        return 3;
    }

    @Override
    public int hashCode() {
        return Objects.hash(_1, _2, _3);
    }

    @Override
    public String toString() {
        return String.format("(%s, %s, %s)", _1, _2, _3);
    }

}
