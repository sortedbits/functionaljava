package com.sortedbits.functionaljava.control;

import static java.util.Arrays.stream;
import static java.util.Objects.requireNonNull;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class PatternMatch {

    public static class Match<A> {

        private Nullable<A> exp;

        private Match(A exp) {
            this.exp = new Nullable<>(exp);
        }

        @SafeVarargs
        public final <C> C of(Case<A, ?, C>... cases) {

            return stream(cases)
                    .map(c -> c.apply(exp))
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .findFirst().orElseThrow(() -> new MatchError(exp))
                    .get();
        }
    }

    interface Pattern<A, B> extends Function<Nullable<A>, Optional<Nullable<B>>> {

    }

    public static class Case<A, B, C> implements Function<Nullable<A>, Optional<Nullable<C>>> {

        private Pattern<A, B> pattern;
        private Function<B, C> function;

        Case(Pattern<A, B> pattern, Function<B, C> function) {
            this.pattern = pattern;
            this.function = function;
        }

        @Override
        public Optional<Nullable<C>> apply(Nullable<A> obj) {
            return pattern.apply(obj).map(x -> new Nullable<>(function.apply(x.get())));
        }
    }

    public static <A> Match<A> match(A exp) {
        return new Match<>(exp);
    }

    public static <A, B, C> Case<A, B, C> caseOf(Pattern<A, B> pattern, C value) {
        return caseOf(pattern, ignored -> value);
    }

    public static <A, B, C> Case<A, B, C> caseOf(Pattern<A, B> pattern, Supplier<C> supplier) {
        return caseOf(pattern, ignored -> supplier.get());
    }

    public static <A, B, C> Case<A, B, C> caseOf(Pattern<A, B> pattern, Function<B, C> function) {
        return new Case<>(pattern, function);
    }

    public static <A> Pattern<A, A> value(A value) {

        return x -> new Nullable<>(value).equals(x) ? Optional.of(new Nullable<>(value)) : Optional.empty();
    }

    public static <A> Pattern<A, A> predicate(Predicate<A> predicate) {

        requireNonNull(predicate);

        return x -> predicate.test(x.get()) ? Optional.of(x) : Optional.empty();
    }

    public static <A> Pattern<A, A> any() {
        return Optional::of;
    }

    public static <B, C> Function<B, C> run(Consumer<B> consumer) {

        requireNonNull(consumer);

        return x -> {
            consumer.accept(x);
            return null;
        };
    }

}

