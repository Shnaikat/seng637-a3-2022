package org.jfree.data;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.*;

public class RangeShiftTest {

	private Range baseRange;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("The test of the function 'shift' of the class Range has been started.");
	}

	@Before
	public void setUp() throws Exception {
		baseRange = new Range(-1, 1);
	}

	@Test
	public void shiftTowardsPositiveScaleByCrossingZero() {
		// (-1,+1) --Shift 2 to right --> (+1,+3)
		assertEquals("The range's lower and upper bounds should be added by 2 with lower bound crossing zero",
				new Range(1, 3), Range.shift(baseRange, 2, true));
	}

	@Test
	public void shiftTowardsNegativeScaleByCrossingZero() {
		// (-1,+1) --Shift 2 to left --> (-3,-1)
		assertEquals("The range's lower and upper bounds should be subtracted by 2 with upper bound crossing zero",
				new Range(-3, -1), Range.shift(baseRange, -2, true));
	}
	
	@Test
	public void shiftTowardsPositiveScaleWithoutCrossingZero() {
		// (-1,+1) --Shift 2 to right, Not passing 0 --> (0,+3)
		assertEquals(
				"The range's lower and upper bounds should be added by 2 without crossing zero, so lower bound's value should be zero",
				new Range(0, 3), Range.shift(baseRange, 2, false));
	}

	@Test
	public void shiftTowardsNegativeScaleWithoutCrossingZero() {
		// (-1,+1) --Shift 2 to left, Not passing 0 --> (-.3,0)
		assertEquals(
				"The range's lower and upper bounds should be subtracted by 2 without crossing zero, so upper bound's value should be zero",
				new Range(-3, 0), Range.shift(baseRange, -2, false));
	}	
	
	@Test
	public void shiftValueIsZero() {
		// (-1,+1) --Shift 2 to left, Not passing 0 --> (-.3,0)
		assertEquals(
				"Shift value is zero, so same range as result",
				baseRange, Range.shift(baseRange, 0, false));
	}	
	

	@After
	public void tearDown() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

}
