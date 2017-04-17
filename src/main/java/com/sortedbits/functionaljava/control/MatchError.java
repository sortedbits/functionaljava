package com.sortedbits.functionaljava.control;

import java.util.NoSuchElementException;

public class MatchError extends NoSuchElementException{

    private final Object obj;

    MatchError(Object obj) {
        this.obj = obj;
    }

    public Object getObject() {
        return obj;
    }

}