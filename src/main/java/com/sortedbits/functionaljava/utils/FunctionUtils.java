package com.sortedbits.functionaljava.utils;

import java.util.function.BiFunction;
import java.util.function.Function;

import com.sortedbits.functionaljava.TriFunction;

public class FunctionUtils{

	private FunctionUtils() {		
	}
	
	public static <A, B, C> Function<A, C> partial1(BiFunction<A, B, C> f, B b) {
		return (A a) -> f.apply(a, b);
	}

	public static <A, B, C> Function<B, C> partial2(BiFunction<A, B, C> f, A a) {
		return (B b) -> f.apply(a, b);
	}
		
	public static <A, B, C, D> Function<A, D> partial1(TriFunction<A, B, C, D> f, B b, C c) {
		return (A a) -> f.apply(a, b, c);
	}
	
	public static <A, B, C, D> Function<B, D> partial2(TriFunction<A, B, C, D> f, A a, C c) {
		return (B b) -> f.apply(a, b, c);
	}

	public static <A, B, C, D> BiFunction<A, C, D> partial13(TriFunction<A, B, C, D> f, B b) {
		return (A a, C c) -> f.apply(a, b, c);
	}
	
	public static <A, B, C, D> BiFunction<A, B, D> partial12(TriFunction<A, B, C, D> f, C c) {
		return (A a, B b) -> f.apply(a, b, c);
	}
	
	public static <A, B, C, D> BiFunction<B, C, D> partial23(TriFunction<A, B, C, D> f, A a) {
		return (B b, C c) -> f.apply(a, b, c);
	}

}
