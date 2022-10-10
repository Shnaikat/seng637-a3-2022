package org.jfree.data;

import static org.junit.Assert.*;
import org.jfree.data.DataUtilities;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * The function 'static Number[][] createNumberArray(double[][] data)'
 * Constructs a 2D array of Number objects from a 2D array of double primitives.
 * This class tests this function for 5 different scenarios. First: When the
 * array is empty Second: When the array has 1 valid random double value Third:
 * When the array has only one column of boundary values Fourth: When the array
 * has only one row of boundary values Fifth: When the array has 3 rows and 3
 * columns of boundary values
 * 
 * @author Group#4
 *
 */
public class DataUtilitiesCreateNumberArray2DTest {

	private double[][] doubleEmpty;
	private double[][] doubleSingle;
	private double[][] doubleRowBoundaries;
	private double[][] doubleColumnBoundaries;
	private double[][] doubleMxNBoundaries;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("The test of function 'CreateNumberArray2D' of the class DataUtilities has been started.");
	}

	@Before
	public void setUp() throws Exception {

		// Empty
		double[][] d0 = {};
		doubleEmpty = d0;

		// Generates a random single value array
		Double min = -1.23456e-300d;
		Double max = 1.23456e300d;
		double d = (Math.random() * ((max - min) + 1)) + min;
		double[][] d1 = {{d}};
		doubleSingle = d1;
		
		// Generates a row value array

		double[][] d2 = { 
							{
								Double.MAX_VALUE, 
								0.0d, 
								Double.MIN_NORMAL, 
								Double.MIN_VALUE, 
								Double.NEGATIVE_INFINITY,
								Double.POSITIVE_INFINITY, 
								Double.MAX_EXPONENT, 
								Double.MIN_EXPONENT, 
								1.23456e300d, 
								-1.23456e-300d,
								1e1d
							}
						};
		doubleRowBoundaries = d2;
		
		// Generates a column value array

		double[][] d3 = { 
							{Double.MAX_VALUE}, 
							{0.0d}, 
							{Double.MIN_NORMAL}, 
							{Double.MIN_VALUE}, 
							{Double.NEGATIVE_INFINITY},
							{Double.POSITIVE_INFINITY}, 
							{Double.MAX_EXPONENT}, 
							{Double.MIN_EXPONENT}, 
							{1.23456e300d}, 
							{-1.23456e-300d},
							{1e1d} 
						};
		doubleColumnBoundaries = d3;
		
		// Generates a 3x4 row value array

				double[][] d4 = { 
									{
										Double.MAX_VALUE, 
										0.0d, 
										Double.MIN_NORMAL 
									},
									{
										Double.MIN_VALUE, 
										Double.NEGATIVE_INFINITY,
										Double.POSITIVE_INFINITY
									},
									{
										Double.MAX_EXPONENT, 
										Double.MIN_EXPONENT, 
										1.23456e300d
									},
									{
										-1.23456e-300d,
										1e1d,
										d
									}
								};
				doubleMxNBoundaries = d4;

	}
	
	@SuppressWarnings({ "deprecation" })
	@Test
	public void createNumberArray2DForEmptyDoubleArray() {
		// int, double, float
		// Integer, Double, Float : Number
		Double[][] doubleArr = dArray2DArray(doubleEmpty);
		Number[][] numberArr = doubleArr;
		Number[][] result = DataUtilities.createNumberArray2D(doubleEmpty);

		// Assert object by object
		assertEquals(result, numberArr);

		// Assert arrays' sizes
		assertEquals(0, result.length);
	}
	
	@SuppressWarnings({ "deprecation" })
	@Test
	public void createNumberArrayForSingleDoubleArray() {

		Double[][] doubleArr = dArray2DArray(doubleSingle);
		Number[][] numberArr = doubleArr;
		Number[][] result = DataUtilities.createNumberArray2D(doubleSingle);

		// Assert object by object
		assertEquals(result, numberArr);
		assertEquals(numberArr[0], result[0]);
		
		// Assert arrays' sizes
		assertEquals(1, result.length);
		assertEquals(1, result[0].length);

		// Assert element by element
		assertEquals(doubleSingle[0][0], result[0][0]);
	}

	
	@SuppressWarnings({ "deprecation" })
	@Test
	public void createNumberArray2DForSingleRowDoubleArray() {
		Double[][] doubleArr = dArray2DArray(doubleRowBoundaries);

		Number[][] numberArr = doubleArr;
		Number[][] result = DataUtilities.createNumberArray2D(doubleRowBoundaries);

		// Assert object by object
		assertEquals(result, numberArr);
		assertEquals(result[0], numberArr[0]);

		// Assert arrays' sizes
		assertEquals(numberArr.length, result.length);
		assertEquals(numberArr[0].length, result[0].length);
		
		// Assert element by element
		assertEquals(Double.MAX_VALUE, result[0][0]);
		assertEquals(0.0d, result[0][1]);
		assertEquals(Double.MIN_NORMAL, result[0][2]);
		assertEquals(Double.MIN_VALUE, result[0][3]);
		assertEquals(Double.NEGATIVE_INFINITY, result[0][4]);
		assertEquals(Double.POSITIVE_INFINITY, result[0][5]);
		assertEquals((double) Double.MAX_EXPONENT, result[0][6]);
		assertEquals((double) Double.MIN_EXPONENT, result[0][7]);
		assertEquals(1.23456e300d, result[0][8]);
		assertEquals(-1.23456e-300d, result[0][9]);
		assertEquals(1e1d, result[0][10]);
	}

	
	@SuppressWarnings({ "deprecation" })
	@Test
	public void createNumberArray2DForSingleColumnDoubleArray() {
		Double[][] doubleArr = dArray2DArray(doubleColumnBoundaries);

		Number[][] numberArr = doubleArr;
		Number[][] result = DataUtilities.createNumberArray2D(doubleColumnBoundaries);

		// Assert object by object
		assertEquals(result, numberArr);
		for(int i=0; i< result.length; i++) {
			assertEquals(result[i], numberArr[i]);
		}

		// Assert arrays' sizes
		assertEquals(numberArr.length, result.length);
		for(int i=0; i< result.length; i++) {
			assertEquals(1, result[i].length);
		}
		
		// Assert element by element
		assertEquals(Double.MAX_VALUE, result[0][0]);
		assertEquals(0.0d, result[1][0]);
		assertEquals(Double.MIN_NORMAL, result[2][0]);
		assertEquals(Double.MIN_VALUE, result[3][0]);
		assertEquals(Double.NEGATIVE_INFINITY, result[4][0]);
		assertEquals(Double.POSITIVE_INFINITY, result[5][0]);
		assertEquals((double) Double.MAX_EXPONENT, result[6][0]);
		assertEquals((double) Double.MIN_EXPONENT, result[7][0]);
		assertEquals(1.23456e300d, result[8][0]);
		assertEquals(-1.23456e-300d, result[9][0]);
		assertEquals(1e1d, result[10][0]);
	}
	
	@SuppressWarnings({ "deprecation" })
	@Test
	public void createNumberArray2DForMxNDoubleArray() {
		Double[][] doubleArr = dArray2DArray(doubleMxNBoundaries);

		Number[][] numberArr = doubleArr;
		Number[][] result = DataUtilities.createNumberArray2D(doubleMxNBoundaries);

		// Assert object by object
		assertEquals(numberArr, result);
		for(int i=0; i< result.length; i++) {
			assertEquals(numberArr[i], result[i]);
		}

		// Assert arrays' sizes
		assertEquals(numberArr.length, result.length);
		for(int i=0; i< result.length; i++) {
			assertEquals(numberArr[i].length, result[i].length);
		}
		
		// Assert element by element
		for(int i=0; i< doubleArr.length; i++) {
			for(int j=0; j<doubleArr[i].length; j++) {
				assertEquals(doubleArr[i][j], result[i][j]);
			}
		}
				
	}

	@After
	public void tearDown() throws Exception {

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {

	}
	
	// converts the a 2D double array to a 2D Double array 
	private static Double[][] dArray2DArray(double[][] data) {
		Double[][] doubleArr = new Double[data.length][];
		for (int i = 0; i < data.length; i++) {
			doubleArr[i] = new Double[data[i].length];
			for(int j = 0; j < data[i].length; j++) {
				doubleArr[i][j] = new Double(data[i][j]);
			}
		}
		return doubleArr;
	}
}
