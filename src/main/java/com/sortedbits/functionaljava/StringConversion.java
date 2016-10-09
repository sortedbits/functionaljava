package com.sortedbits.functionaljava;

import java.util.function.Function;

@FunctionalInterface
public interface StringConversion<T> extends Function<T, String> {

	String apply(T object);

	static <T> StringConversion<T> nullSafe(StringConversion<T> conversion) {
		return (T object) -> (object != null) ? conversion.apply(object) : "null";
	}
	
	static <T> StringConversion<T> nullSafe(StringConversion<T> conversion, String nullReplace) {
		return (T object) -> (object != null) ? conversion.apply(object) : nullReplace;
	}
	
}
