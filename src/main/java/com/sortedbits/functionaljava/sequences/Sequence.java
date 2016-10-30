package com.sortedbits.functionaljava.sequences;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

public interface Sequence<T> extends Stream<T> {

    static <T> Sequence<T> sequence(T[] xs) {
        return sequence(Arrays.asList(xs));
    }

    static <T> Sequence<T> sequence(List<T> xs) {
        return null;
    }

    static <T> Sequence<T> sequence(Supplier<T> supplier) {
        return null;
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
        return result;
    }

    static <T> Stream<T> takeWhile(Stream<T> xs, Predicate<T> p) {
        throw new UnsupportedOperationException();
    }

    static <T> Stream<T> dropWhile(Stream<T> xs, Predicate<T> p) {
        throw new UnsupportedOperationException();
    }

}
