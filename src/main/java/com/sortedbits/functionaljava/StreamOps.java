package com.sortedbits.functionaljava;

import com.sortedbits.functionaljava.functions.Function2;

import java.util.Iterator;
import java.util.Spliterators;
import java.util.function.Predicate;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static java.util.Spliterator.ORDERED;

public interface StreamOps {

    static <T> T head(Stream<T> xs) {
        Iterator<T> it = xs.iterator();
        if (it.hasNext()) {
            return it.next();
        } else {
            throw new StreamOpException("head of empty stream");
        }
    }

    static <T> Stream<T> tail(Stream<T> xs) {
        Iterator<T> it = xs.iterator();
        if (it.hasNext()) {
            it.next();
            return (it.hasNext()) ? stream(it) : Stream.empty();
        } else {
            throw new StreamOpException("tail of empty stream");
        }
    }

    static <T> Stream<T> stream(Iterator<T> it) {
        return StreamSupport.stream(Spliterators.spliteratorUnknownSize(it, ORDERED), false);
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

    final class StreamOpException extends RuntimeException {

        private StreamOpException(String message) {
            super(message);
        }
    }
}
