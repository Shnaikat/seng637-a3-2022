package org.jfree.data;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class RangeExpandToIncludeTest {

	private Range exampleRange;
	private Range expectedRangeWithPosVal;
	private Range expectedRangeWithNegVal;
	private double posNewValue;
	private double negNewValue;
	private double existingValue;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("The test of the function 'expandToInclude' of the class Range has been started.");
	}

	@Before
	public void setUp() throws Exception {
		exampleRange = new Range(-1, 1);
		expectedRangeWithPosVal = new Range(-1.0, 2.0);
		expectedRangeWithNegVal = new Range(-2.0, 1.0);
		posNewValue = 2;
		negNewValue = -2;
		existingValue = 0;
	}

	@Test
	public void expandedRangeIncludingTwo() {
		assertEquals("The range -1 and 1 should be -1 and 2 when including 2",
				Range.expandToInclude(exampleRange, posNewValue), expectedRangeWithPosVal);
	}

	@Test
	public void expandedRangeIncludingNegativeTwo() {
		assertEquals("The range -1 and 1 should be -2 and 1 when including -2",
				Range.expandToInclude(exampleRange, negNewValue), expectedRangeWithNegVal);
	}

	@Test
	public void expandedRangeIncludingExistingValueZero() {
		assertEquals("The range -1 and 1 should same when including 0",
				Range.expandToInclude(exampleRange, existingValue), exampleRange);
	}
	
	@Test
	public void expandingNullRange() {
		assertEquals("Should return null",
				Range.expandToInclude(null, 2), new Range(2, 2));
	}

	@After
	public void tearDown() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

}
