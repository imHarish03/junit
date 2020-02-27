package junit.helper;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class ArraysCompareTest {

	@Test
	public void testArraySort_RanodmArray() {
		int[] numbers = { 12, 3, 4, 1 };
		int[] expected = { 1, 3, 4, 12 };

		Arrays.sort(numbers);
		assertArrayEquals(expected, numbers);
	}

	@Test(expected = NullPointerException.class)
	public void testArraySort_NullArray() {
		int[] numbers = null;
		// int[] numbers = null;
		int[] expected = { 1, 3, 4, 12 };

		Arrays.sort(numbers);
		assertArrayEquals(expected, numbers);
	}

	@Test(timeout = 10000)
	public void testArraySort_performance() {
		int[] array = { 12, 1, 3, 199, 4, 5 };

		for (int i = 0; i <= 1000000; i++) {
			array[0] = i;
			Arrays.sort(array);
		}

	}

}
