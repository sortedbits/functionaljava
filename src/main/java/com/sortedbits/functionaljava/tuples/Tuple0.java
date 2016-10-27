package com.sortedbits.functionaljava.tuples;

public class Tuple0 implements Tuple {

    private static final long serialVersionUID = 1L;

    public static final Tuple0 INSTANCE = new Tuple0();

    private Tuple0() {
    }

    @Override
    public final int arity() {
        return 0;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        return obj == this;
    }

    @Override
    public String toString() {
        return "()";
    }
}
