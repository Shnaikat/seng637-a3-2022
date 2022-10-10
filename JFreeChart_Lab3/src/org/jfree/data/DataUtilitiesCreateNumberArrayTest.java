package org.jfree.data;

import static org.junit.Assert.*;
import org.jfree.data.DataUtilities;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * The function 'static Number[] createNumberArray(double[] data)' Constructs an
 * array of Number objects from an array of double primitives. This class tests
 * this function for 3 different scenarios. First: When the array is empty
 * Second: When the array has 1 valid random double value Third: When the array
 * has multiple of boundary values
 * 
 * @author Group#4
 *
 */
public class DataUtilitiesCreateNumberArrayTest {

	private double[] doubleBoundaries;
	private double[] doubleEmpty;
	private double[] doubleSingle;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("The test of function 'CreateNumberArray' of the class DataUtilities has been started.");
	}

	@Before
	public void setUp() throws Exception {
		double[] d1 = { Double.MAX_VALUE, 0.0d, Double.MIN_NORMAL, Double.MIN_VALUE, Double.NEGATIVE_INFINITY,
				Double.POSITIVE_INFINITY, Double.MAX_EXPONENT, Double.MIN_EXPONENT, 1.23456e300d, -1.23456e-300d,
				1e1d };
		doubleBoundaries = d1;
		// Empty
		double[] d2 = {};
		doubleEmpty = d2;

		// Generates a random single value array
		Double min = -1.23456e-300d;
		Double max = 1.23456e300d;
		double d = (Math.random() * ((max - min) + 1)) + min;
		double[] d3 = { d };
		doubleSingle = d3;
	}

	@SuppressWarnings({ "deprecation" })
	@Test
	public void createNumberArrayForMultiDoubleArray() {
		Double[] doubleArr = dArray2DArray(doubleBoundaries);

		Number[] numberArr = doubleArr;
		Number[] result = DataUtilities.createNumberArray(doubleBoundaries);

		// Assert object by object
		assertEquals(result, numberArr);

		// Assert arrays' sizes

		assertEquals(numberArr.length, result.length);

		// Assert element by element

		assertEquals(Double.MAX_VALUE, result[0]);
		assertEquals(0.0d, result[1]);
		assertEquals(Double.MIN_NORMAL, result[2]);
		assertEquals(Double.MIN_VALUE, result[3]);
		assertEquals(Double.NEGATIVE_INFINITY, result[4]);
		assertEquals(Double.POSITIVE_INFINITY, result[5]);
		assertEquals((double) Double.MAX_EXPONENT, result[6]);
		assertEquals((double) Double.MIN_EXPONENT, result[7]);
		assertEquals(1.23456e300d, result[8]);
		assertEquals(-1.23456e-300d, result[9]);
		assertEquals(1e1d, result[10]);

	}

	@SuppressWarnings({ "deprecation" })
	@Test
	public void createNumberArrayForEmptyDoubleArray() {
		Double[] doubleArr = dArray2DArray(doubleEmpty);
		Number[] numberArr = doubleArr;
		Number[] result = DataUtilities.createNumberArray(doubleEmpty);

		// Assert object by object
		assertEquals(result, numberArr);

		// Assert arrays' sizes
		assertEquals(numberArr.length, result.length);
	}

	@SuppressWarnings({ "deprecation" })
	@Test
	public void createNumberArrayForSingleDoubleArray() {

		Double[] doubleArr = dArray2DArray(doubleSingle);
		Number[] numberArr = doubleArr;
		Number[] result = DataUtilities.createNumberArray(doubleSingle);

		// Assert object by object
		assertEquals(result, numberArr);

		// Assert arrays' sizes
		assertEquals(numberArr.length, result.length);

		// Assert element by element
		assertEquals(doubleSingle[0], result[0]);
	}

	@After
	public void tearDown() throws Exception {

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {

	}

	private static Double[] dArray2DArray(double[] data) {
		Double[] doubleArr = new Double[data.length];
		for (int i = 0; i < data.length; i++) {
			doubleArr[i] = new Double(data[i]);
		}
		return doubleArr;
	}
}
