package org.jfree.data;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class RangeIntersectionTest {

	private Range exampleRange;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("The test of the function 'intersection' of the class Range has been started.");
	}

	@Before
	public void setUp() throws Exception {
		exampleRange = new Range(-2, 1);
	}

	@Test
	public void rangeLowerBoundIntersectionShouldBeTrue() {		
		//                (####*****)
		//      (*********####)
		//<-----2----1----0----1----2------>
		assertTrue("The lower bound of new range intersects with example range, hence value should be true",
				exampleRange.intersects(0, 2));
	}

	@Test
	public void rangeUpperBoundIntersectionShouldBeTrue() {
		//  (*****#########)
		//       (#########*****)
		//<-3----2----1----0----1----2------>
		assertTrue("The upper bound of new range intersects with example range, hence value should be true",
				exampleRange.intersects(-3, 0));
	}

	@Test
	public void rangeIntersectionShouldBeFalse1() {
		//  							  (*****)
		//       (**************)
		//<-3----2----1----0----1----2----3----4>
		assertFalse("The ranges do not intersect, hence value should be false", exampleRange.intersects(3, 4));
	}
	
	@Test
	public void rangeIntersectionShouldBeFalse2() {
		assertFalse("The ranges do not intersect, hence value should be false", exampleRange.intersects(-4, -3));
	}

	@Test
	public void rangeIntersectionShouldBeTrue1() {
		assertTrue("The new range completely falls within example range, hence value should be true",
				exampleRange.intersects(-1, 0));
	}
	
	@Test
	public void rangeIntersectionShouldBeTrue2() {
		//  							  (*****)
		//       (**************)
		//<-3----2----1----0----1----2----3----4>
		assertTrue("The example range completely falls within new range, hence value should be true", exampleRange.intersects(-3, 4));
	}
	
	@Test
	public void rangeLowerBoundEqualShouldBeTrue() {		
		//                (####*****)
		//      (*********####)
		//<-----2----1----0----1----2------>
		assertTrue("The lower bound of new range is equal to that of example range, hence value should be true",
				exampleRange.intersects(-2, 0));
	}
	
	@Test
	public void rangeUpperBoundEqualShouldBeTrue() {		
		//                (####*****)
		//      (*********####)
		//<-----2----1----0----1----2------>
		assertTrue("The Upper bound of new range is equal to that of example range, hence value should be true",
				exampleRange.intersects(0, 1));
	}
	
	@Test
	public void rangeWithLBGreaterThanUB() {		
		assertFalse("The example range's LB is greater than UB, hence value should be false",
				exampleRange.intersects(0, -1));
	}

	@After
	public void tearDown() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

}
