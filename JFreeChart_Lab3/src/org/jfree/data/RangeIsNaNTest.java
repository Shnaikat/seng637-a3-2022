package org.jfree.data;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class RangeIsNaNTest {

	private Range nonNanExampleRange;
	private Range NanExampleRange;
	private Range lbNanExampleRange;
	private Range ubNanExampleRange;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("The test of the function 'isNan' of the class Range has been started.");
	}

	@Before
	public void setUp() throws Exception {
		nonNanExampleRange = new Range(-1, 1);
		NanExampleRange = new Range(Float.NaN, Float.NaN);
		lbNanExampleRange = new Range(Float.NaN, 1);
		ubNanExampleRange = new Range(-1, Float.NaN);
	}

	@Test
	public void noNaNValuesInRange() {
		assertFalse("The example range does not have any NaN values, should return false",
				nonNanExampleRange.isNaNRange());
	}

	@Test
	public void bothNaNValuesInRange() {
		assertTrue("The range has both NaN values in upper and lower bounds, should return true",
				NanExampleRange.isNaNRange());
	}

	@Test
	public void lowerBoundNaNValueInRange() {
		assertFalse("The range has one NaN value in lower bound, should return false", lbNanExampleRange.isNaNRange());
	}

	@Test
	public void upperBoundNaNValueInRange() {
		assertFalse("The range has one NaN value in upper bound, should return false", ubNanExampleRange.isNaNRange());
	}

	@After
	public void tearDown() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

}
