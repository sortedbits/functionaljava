package com.sortedbits.functionaljava;


import java.util.Collection;
import java.util.Optional;
import java.util.stream.Stream;

public class StringOps {

    static <T> String mkString(Collection<T> collection, String sep) {
        return mkString(collection, "", sep,  "");
    }

    static <T> String mkString(Collection<T> collection, String start, String sep, String end) {
        return mkString(collection.stream(), start, sep,  end);
    }

    static <T> String mkString(Stream<T> stream, String sep) {
        return mkString(stream, "", sep, "");
    }

    static <T> String mkString(
            Stream<T> stream,
            String start,
            String sep,
            String end) {
        StringBuilder sb = new StringBuilder(start);
        Optional<String> os = stream.map(StringOps::safeToString).reduce((x, y) -> x + sep + y);
        os.ifPresent(sb::append);
        return sb.append(end).toString();
    }

    static String safeToString(Object obj) {
        return (obj != null) ? obj.toString() : "null";
    }
}
