package com.sortedbits.functionaljava;


import java.util.Collection;
import java.util.Optional;
import java.util.stream.Stream;

import static java.lang.String.format;
import static java.util.stream.Collectors.joining;

public class StringOps {

    static <T> String mkString(Collection<T> collection, String sep) {
        return mkString(collection, "", sep, "");
    }

    static <T> String mkString(Collection<T> collection, String start, String sep, String end) {
        return mkString(collection.stream(), start, sep, end);
    }

    static <T> String mkString(Stream<T> stream, String sep) {
        return mkString(stream, "", sep, "");
    }

    static <T> String mkString(
            Stream<T> stream,
            String start,
            String sep,
            String end) {
        return format("%s%s%s", start, stream.map(StringOps::safeToString).collect(joining(sep)), end);
    }

    static String safeToString(Object obj) {
        return Optional.ofNullable(obj).map(Object::toString).orElse("null");
    }
}
