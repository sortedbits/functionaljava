package com.sortedbits.functionaljava.tuples;

public class Unit implements Tuple {

	public static final Unit UNIT = new Unit();
	
    private Unit() {
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
        return String.format("()");
    }
}
