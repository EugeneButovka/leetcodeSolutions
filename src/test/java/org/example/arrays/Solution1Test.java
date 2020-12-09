package org.example.arrays;

import org.example.SolutionArrays1;
import org.example.UniqCountSpliterator;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class Solution1Test {
	
	@Test
	@Disabled
	public void test() {
		Stream<Integer> input = Stream.of(0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1);
		
		UniqCountSpliterator uniqCountSpliterator = new UniqCountSpliterator(input.spliterator());
		
		long[] output = uniqCountSpliterator.stream()
				.toArray();
		
		long[] expected = {3, 2, 2, 4};
		
		assertArrayEquals(expected, output);
	}
	
	@ParameterizedTest
	@MethodSource("testsProvider")
	public void testSpliteratorParametric(int[] testCase, int expected) {
		Stream<Integer> input = Arrays.stream(testCase).boxed();
		
		UniqCountSpliterator uniqCountSpliterator = new UniqCountSpliterator(input.spliterator());
		
		OptionalInt output = uniqCountSpliterator.stream()
				.mapToInt(i -> (int) i).max();
		System.out.println("output: " + Arrays.toString(uniqCountSpliterator.stream()
				.toArray()));
		
		assertEquals(expected, output.orElse(0));
	}
	
	
	
	
	@ParameterizedTest
	@MethodSource("testsProvider")
	public void checkSolution(int[] testCase, int expected) {
		System.out.println("Testing with input: " + Arrays.toString(testCase) + " and expected output: " + expected);
		
		
		assertEquals(expected, SolutionArrays1.findMaxConsecutiveOnes(testCase));
	}
	
	
	static Stream<Arguments> testsProvider() {
		/*int[][][] array =
				{
						{{1, 0}, {1}},
						{{1, 0}, {1}},
						{{1, 0}, {1}},
				};*/
		//return Arrays.stream(array).sequential();
		return Stream.of(
				//test case as array - correct answer as int
				arguments(new int[]{1}, 1),
				arguments(new int[]{0}, 0),
				arguments(new int[]{1, 0}, 1),
				arguments(new int[]{0, 1}, 1),
				arguments(new int[]{1, 0, 1}, 1),
				arguments(new int[]{1, 1 , 0, 1}, 2)
		);
	}
}



	
