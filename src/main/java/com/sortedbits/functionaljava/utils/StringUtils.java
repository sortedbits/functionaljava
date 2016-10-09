package com.sortedbits.functionaljava.utils;

import java.util.Collection;
import java.util.stream.Stream;

import com.sortedbits.functionaljava.StringConversion;

public class StringUtils {

	public static <T> String mkString(Collection<T> collection, String sep, String start, String end) {
		return mkString(collection.stream(), StringConversion.nullSafe(Object::toString), sep, start, end);
	}
	
	public static <T> String mkString(Collection<T> collection, StringConversion<T> f, String sep, String start, String end) {
		return mkString(collection.stream(), f, sep, start, end);
	}
	
	public static <T> String mkString(Stream<T> stream, StringConversion<T> f, String sep) {
		return mkString(stream, f, sep, "", "");
	}
	
	public static <T> String mkString(
			Stream<T> stream, 
			StringConversion<T> f, 
			String sep, 
			String start, 
			String end) {
		return new StringBuilder(start)
				.append(stream.map(f).reduce((x, y) -> x + sep + y).get())
				.append(end)
				.toString();
	}
		
}
