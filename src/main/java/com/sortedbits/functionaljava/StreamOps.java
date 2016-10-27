package com.sortedbits.functionaljava;

import com.sortedbits.functionaljava.functions.Function2;

import java.util.Iterator;
import java.util.Spliterators;
import java.util.function.BiFunction;
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

    static <T> Stream<T> concat(Stream<T> before, Stream<T> after) {
        return Stream.concat(before, after);
    }

    static <T> Stream<T> append(Stream<T> xs, T x) {
        return Stream.concat(xs, Stream.of(x));
    }

    static <T> Stream<T> cons(T x, Stream<T> xs) {
        return Stream.concat(Stream.of(x), xs);
    }

    static <T> Stream<T> stream(Iterator<T> it) {
        return StreamSupport.stream(Spliterators.spliteratorUnknownSize(it, ORDERED), false);
    }

    /*
    static <A, B> B foldRight(Stream<A> xs, B x, Function2<A, B, B> f) {
        return f.apply(head(xs), foldRight(tail(xs), x, f));
    }
    */

    static <A, B> B foldLeft(Stream<A> xs, B x, BiFunction<B, A, B> f) {
        B result = x;
        Iterator<A> it = xs.iterator();
        while (it.hasNext()) {
            result = f.apply(result, it.next());
        }
        return x;
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
