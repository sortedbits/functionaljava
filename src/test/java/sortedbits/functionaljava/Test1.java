package sortedbits.functionaljava;

import java.util.Arrays;
import java.util.stream.Collectors;

import static sortedbits.functionaljava.Test.assertThrows;
import org.junit.Test;

public class Test1 {

	@Test
	public void test() {
		ThrowingFunction<Integer, Integer> f =  (Integer x) -> { if (x == 3) return x; else throw new Exception("3"); }; 	
		assertThrows(RuntimeException.class, () -> Arrays.asList(new Integer[] {1, 2, 3}).stream().map(f).collect(Collectors.toList()));
	}
	
}
