package sortedbits.functionaljava;

import java.util.Collection;
import java.util.function.Function;
import java.util.stream.Stream;

public class StringExtensions {

	public static String safeString(Object object) {
		return safeString(object, "null");
	}
	
	public static String safeString(Object object, String replaceNull) {
		return object != null ? object.toString() : replaceNull;
	}
	
	public static String mkString(Collection<?> collection, String separator) {
		return mkString(collection.stream(), separator);
	}

	public static String mkString(Collection<?> collection, String separator, String start, String end) {
		return mkString(collection.stream(), separator, start, end);
	}

	public static String mkString(Stream<?> stream, String separator) {
		return mkString(stream, separator, "", "");
	}
	
	public static String mkString(Stream<?> stream, String separator, String start, String end) {
		return mkString(stream, StringExtensions::safeString, separator, start, end);
	}
	
	public static String mkString(Stream<?> stream, Function<Object, String> f, String separator, String start, String end) {
		return new StringBuilder(start)
				.append(stream.map(f).reduce((x, y) -> x + separator + y).get())
				.append(end)
				.toString();
	}
		
}
