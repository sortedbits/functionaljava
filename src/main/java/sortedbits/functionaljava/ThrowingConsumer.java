package sortedbits.functionaljava;

import java.util.function.Consumer;

@FunctionalInterface
public interface ThrowingConsumer<T> extends Consumer<T> {

	@Override
	default void accept(T arg) {
		try {
			acceptThrows(arg);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	void acceptThrows(T arg) throws Exception;
	
}
