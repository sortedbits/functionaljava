package com.sortedbits.functionaljava;

import com.sortedbits.functionaljava.functions.Function2;

import java.util.function.Predicate;
import java.util.stream.Stream;

public interface StreamOps {

    static <T> T head(Stream<T> xs) {
        return xs.iterator().next();
    }

    static <T> Stream<T> tail(Stream<T> xs) {
        throw new UnsupportedOperationException();
    }

    static <A, B> Stream<B> foldRight(Stream<A> xs, B x, Function2<A, B, B> f) {
        throw new UnsupportedOperationException();
    }

    static <A, B> Stream<B> foldLeft(Stream<A> xs, B x, Function2<B, A, B> f) {
        throw new UnsupportedOperationException();
    }

    static <T> Stream<T> takeWhile(Stream<T> xs, Predicate<T> p) {
        throw new UnsupportedOperationException();
    }

    static <T> Stream<T> dropWhile(Stream<T> xs, Predicate<T> p) {
        throw new UnsupportedOperationException();
    }
}
