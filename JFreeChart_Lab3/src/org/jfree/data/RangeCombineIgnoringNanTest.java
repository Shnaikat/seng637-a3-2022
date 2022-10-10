package org.jfree.data;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.*;

public class RangeCombineIgnoringNanTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("The test of the function 'combineIgnoringNan' of the class Range has been started.");
	}
	// (-1,0)  (1,2) => (-1,2)

	@Test
	public void shouldIgnoreLowerBoundNaNInRange1() {
		assertEquals("The new range should ignore Nan in lower bound of 1st range and use that of the 2nd range",
				new Range(0, 4), Range.combineIgnoringNaN(new Range(Double.NaN, -1), new Range(0, 4)));
	}

	@Test
	public void shouldIgnoreUpperBoundNaNInRange1() {
		assertEquals("The new range should ignore Nan in upper bound of 1st range and use that of the 2nd range",
				new Range(-1, 4), Range.combineIgnoringNaN(new Range(-1, Double.NaN), new Range(0, 4)));
	}

	@Test
	public void shouldIgnoreLowerBoundNaNInRange2() {
		assertEquals("The new range should ignore Nan in lower bound of 2nd range and use that of the 1st range",
				new Range(-1, 5), Range.combineIgnoringNaN(new Range(-1, 4), new Range(Double.NaN, 5)));
	}

	@Test
	public void shouldIgnoreUpperBoundNaNInRange2() {
		assertEquals("The new range should ignore Nan in upper bound of 2nd range and use that of the 1st range",
				new Range(-2, 4), Range.combineIgnoringNaN(new Range(-1, 4), new Range(-2, Double.NaN)));
	}

	@Test
	public void shouldIgnoreNaNInRange2() {
		assertEquals("The new range should ignore 2nd range completely", new Range(-1, 4),
				Range.combineIgnoringNaN(new Range(-1, 4), new Range(Double.NaN, Double.NaN)));
	}

	@Test
	public void shouldIgnoreNaNInRange1() {
		assertEquals("The new range should ignore 1st range completely", new Range(-1, 4),
				Range.combineIgnoringNaN(new Range(Double.NaN, Double.NaN), new Range(-1, 4)));
	}
	
	@Test
	public void shouldReturnNullAsResult() {
		assertEquals("The new range has no values, because all bounds are NaN!", null,
				Range.combineIgnoringNaN(new Range(Double.NaN, Double.NaN), new Range(Double.NaN, Double.NaN) ));
	}
	
	@Test
	public void range1NullWithRange2NaN() {
		assertEquals("Since range1 is NULL and range2 has NaN values, should return null", null,
				Range.combineIgnoringNaN(null, new Range(Double.NaN, Double.NaN) ));
	}
	
	@Test
	public void range1NullWithRange2NonNaN() {
		assertEquals("Since range1 is NULL and range2 has non-NaN values, should return range2", new Range(1, 2),
				Range.combineIgnoringNaN(null, new Range(1, 2) ));
	}
	
	@Test
	public void range2NullWithRange1NaN() {
		assertEquals("Since range2 is NULL and range1 has NaN values, should return null", null,
				Range.combineIgnoringNaN(new Range(Double.NaN, Double.NaN), null));
	}
	
	@Test
	public void range2NullWithRange1NonNaN() {
		assertEquals("Since range2 is NULL and range1 has non-NaN values, should return range1", new Range(1, 2),
				Range.combineIgnoringNaN(new Range(1, 2), null));
	}
	
	@Test
	public void bothRangesNull() {
		assertEquals("Since both ranges are null, should return null", null,
				Range.combineIgnoringNaN(null, null));
	}
	
	@Test
	public void bothRangesNaN() {
		assertEquals("Since both ranges have NaNs as both bound values, should return null", null,
				Range.combineIgnoringNaN(new Range(Double.NaN, Double.NaN), new Range(Double.NaN, Double.NaN)));
	}
	
	@Test
	public void lowerBoundNaN() {
		Range result = Range.combineIgnoringNaN(new Range(Double.NaN, 2), new Range(Double.NaN, 3));
		assertTrue("Since both ranges have NaNs as in LBs, should return new range with NaN in LB and max of UBs", 
			   Double.isNaN(result.getLowerBound()));
	}
	
	@Test
	public void upperBoundNaN() {
		Range result = Range.combineIgnoringNaN(new Range(2, Float.NaN), new Range(3, Float.NaN));
		assertTrue("Since both ranges have NaNs as in UBs, should return new range with NaN in UB and min of LBs", 
			   Double.isNaN(result.getUpperBound()));
	}


	@After
	public void tearDown() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

}
