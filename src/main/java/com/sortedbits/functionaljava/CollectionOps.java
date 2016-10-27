package com.sortedbits.functionaljava;

import com.sortedbits.functionaljava.functions.Function2;
import com.sortedbits.functionaljava.tuples.Tuple2;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static com.sortedbits.functionaljava.tuples.Tuple.pair;
import static java.lang.Math.min;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;
import static java.util.stream.IntStream.range;

public interface CollectionOps {

    static <T> List<T> list(T...xs) {
        return Arrays.asList(xs);
    }

    static <T> List<T> list(List<T> xs) {
        return new ArrayList(xs);
    }

    static <K, V> Map<K, V> map(Map.Entry<K, V>...xs) {
        return Arrays.stream(xs).collect(toMap(x -> x.getKey(), x -> x.getValue(), (x1, x2) -> x2));
    }

    static <T1, T2> List<Tuple2<T1, T2>> zip(List<T1> xs, List<T2> ys) {
        return range(0, min(xs.size(), ys.size())).mapToObj(i -> pair(xs.get(i), ys.get(i))).collect(toList());
    }

    static <T1, T2> Tuple2<List<T1>, List<T2>> unzip(List<Tuple2<T1, T2>> zs) {
        Tuple2<List<T1>, List<T2>> identity = pair(list(), list());
        BiFunction<Tuple2<List<T1>, List<T2>>, ? super Tuple2<T1, T2>, Tuple2<List<T1>, List<T2>>> accumulator =
                (ts, t) -> {
                    List<T1> xs = list(ts._1);
                    xs.add(t._1);
                    List<T2> ys = list(ts._2);
                    ys.add(t._2);
                    return pair(xs, ys);
                };
        BinaryOperator<Tuple2<List<T1>, List<T2>>> combiner =
                (t1, t2) -> {
                    List<T1> xs = list(t1._1);
                    xs.addAll(t2._1);
                    List<T2> ys = list(t1._2);
                    ys.addAll(t2._2);
                    return pair(xs, ys);
                };
        return zs.stream().reduce(identity, accumulator, combiner);
    }
}
