package com.sortedbits.functionaljava;

import static com.sortedbits.functionaljava.utils.TestUtils.assertThrows;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.junit.Test;

import com.sortedbits.functionaljava.throwing.ThrowingFunction;

public class Test1 {

	@Test
	public void test() {
		ThrowingFunction<Integer, Integer> f =  (Integer x) -> { if (x == 3) return x; else throw new Exception("3"); }; 	
		assertThrows(RuntimeException.class, () -> Arrays.asList(new Integer[] {1, 2, 3}).stream().map(f).collect(Collectors.toList()));
	}
	
}
