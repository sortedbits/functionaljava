package com.sortedbits.functionaljava.control;

import java.util.Objects;

public class Nullable<T> {

    private T value;

    Nullable(T value) {
        this.value = value;
    }

    boolean isNull() {
        return value == null;
    }

    T get() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        return (obj == this) || (obj instanceof Nullable && Objects.equals(value, ((Nullable<?>) obj).value));
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}
