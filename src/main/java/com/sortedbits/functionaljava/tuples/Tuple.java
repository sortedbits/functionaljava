package com.sortedbits.functionaljava.tuples;

public interface Tuple {

    static <T1, T2> Tuple2<T1, T2> of(T1 _1, T2 _2) {
        return new Tuple2(_1, _2);
    }

    static <T1, T2, T3> Tuple3<T1, T2, T3> of(T1 _1, T2 _2, T3 _3) {
        return new Tuple3(_1, _2, _3);
    }

    static <T1, T2, T3, T4> Tuple4<T1, T2, T3, T4> of(T1 _1, T2 _2, T3 _3, T4 _4) {
        return new Tuple4(_1, _2, _3, _4);
    }

    int arity();

}