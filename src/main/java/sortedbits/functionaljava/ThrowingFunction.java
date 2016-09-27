package sortedbits.functionaljava;

import java.util.function.Function;

@FunctionalInterface
public interface ThrowingFunction<T, R> extends Function<T, R> {
	
	@Override
	default R apply(T arg) {
		try {
			return applyThrows(arg);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}		
	}
	
	R applyThrows(T arg) throws Exception;
		
}
