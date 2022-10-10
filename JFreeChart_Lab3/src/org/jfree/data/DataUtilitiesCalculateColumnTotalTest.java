package org.jfree.data;

import static org.junit.Assert.*;

import org.jfree.data.DataUtilities;
import org.jfree.data.Values2D;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * This class validate the function `static double calculateColumnTotal(Values2D data, int column)`
 * of the class `DataUtilities`.
 * It is expected that the function receives a 2D table and a column number and 
 * then it returns the total of the values in the passed column of the supplied data table.
 * 
 * We tested the function for different combination of positive and negative values, single element and 
 * empty arrays. Also, we covered the precision test. 
 * 
 * @author Group#4
 *
 */
public class DataUtilitiesCalculateColumnTotalTest {
	
	Mockery mockingContext;
	Values2D values2D;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("The test of the function 'CalculateColumnTotal' of the class DataUtilities has been started.");
	}

	@Before
	public void setUp() throws Exception {
		mockingContext = new Mockery();	
		values2D = mockingContext.mock(Values2D.class);
	}

	@Test
	public void calculateColumnTotalForTwoPositiveValues() {
		mockingContext.checking(new Expectations() {
			{
				one(values2D).getRowCount();
				will(returnValue(2));
				one(values2D).getValue(0, 0); // int row, int column
				will(returnValue(7.6d));
				one(values2D).getValue(1, 0); // int row, int column
				will(returnValue(2.4d));
				//	    0
				//--------
				//0 |  7.6
				//1 |  2.4
			}
		});
		// exercise
		// Returns the total of the values in one column of the supplied data table.
		double result = DataUtilities.calculateColumnTotal(values2D, 0); 
		// verify
		assertEquals("Two positive double values passed and expect 10.0d as result", result, 10.0, .000000001d);
		// tear-down: NONE in this test method
	}	
	
	@Test
	public void calculateColumnTotalForTwoNegativeValues() {
		mockingContext.checking(new Expectations() {
			{
				one(values2D).getRowCount();
				will(returnValue(2));
				one(values2D).getValue(0, 0); // int row, int column
				will(returnValue(-7.6));
				one(values2D).getValue(1, 0); // int row, int column
				will(returnValue(-2.4));				
			}
		});
		// exercise
		// Returns the total of the values in one column of the supplied data table.
		double result = DataUtilities.calculateColumnTotal(values2D, 0); 
		// verify
		assertEquals("Two negative double values passed and expect -10.0d as result", result, -10.0, .000000001d);
		// tear-down: NONE in this test method
	}	
	
	@Test
	public void calculateColumnTotalForTwoNegativePositiveValues() {
		mockingContext.checking(new Expectations() {
			{
				one(values2D).getRowCount();
				will(returnValue(2));
				one(values2D).getValue(0, 0); // int row, int column
				will(returnValue(-7.5));
				one(values2D).getValue(1, 0); // int row, int column
				will(returnValue(2.5));				
			}
		});
		// exercise
		// Returns the total of the values in one column of the supplied data table.
		double result = DataUtilities.calculateColumnTotal(values2D, 0); 
		// verify
		assertEquals("Two negative and positive double values passed and expect 5.0d as result", result, -5.0, .000000001d);
		// tear-down: NONE in this test method
	}	
	
	@Test
	public void calculateColumnTotalForTwoPositiveNegativeValues() {
		mockingContext.checking(new Expectations() {
			{
				one(values2D).getRowCount();
				will(returnValue(2));
				one(values2D).getValue(0, 0); // int row, int column
				will(returnValue(7.5));
				one(values2D).getValue(1, 0); // int row, int column
				will(returnValue(-2.5));				
			}
		});
		// exercise
		// Returns the total of the values in one column of the supplied data table.
		double result = DataUtilities.calculateColumnTotal(values2D, 0); 
		// verify
		assertEquals("Two negative and positive double values passed and expect 5.0d as result", result, 5.0, .000000001d);
		// tear-down: NONE in this test method
	}	
	
	@Test
	public void calculateColumnTotalForTwoOppositePolaritySameMagnitudeValues() {
		mockingContext.checking(new Expectations() {
			{
				one(values2D).getRowCount();
				will(returnValue(2));
				one(values2D).getValue(0, 0); // int row, int column
				will(returnValue(7.5));
				one(values2D).getValue(1, 0); // int row, int column
				will(returnValue(-7.5));				
			}
		});
		// exercise
		// Returns the total of the values in one column of the supplied data table.
		double result = DataUtilities.calculateColumnTotal(values2D, 0); 
		// verify
		assertEquals("Two opposite polarity same magnitude double values passed and expect 0.0d as result", result, 0.0, .000000001d);
		// tear-down: NONE in this test method
	}
	
	@Test
	public void calculateColumnTotalForTwoZeroValues() {
		mockingContext.checking(new Expectations() {
			{
				one(values2D).getRowCount();
				will(returnValue(2));
				one(values2D).getValue(0, 0); // int row, int column
				will(returnValue(0.0));
				one(values2D).getValue(1, 0); // int row, int column
				will(returnValue(0.0));				
			}
		});
		// exercise
		// Returns the total of the values in one column of the supplied data table.
		double result = DataUtilities.calculateColumnTotal(values2D, 0); 
		// verify
		assertEquals(result, 0.0, .000000001d);
		// tear-down: NONE in this test method
	}
	
	@Test
	public void calculateColumnTotalForSingleValue() {
		mockingContext.checking(new Expectations() {
			{
				one(values2D).getRowCount();
				will(returnValue(1));
				one(values2D).getValue(0, 0); // int row, int column
				will(returnValue(50.36598));			
			}
		});
		// exercise
		// Returns the total of the values in one column of the supplied data table.
		double result = DataUtilities.calculateColumnTotal(values2D, 0); 
		// verify
		assertEquals(result, 50.36598, .000000000d);
		// tear-down: NONE in this test method
	}
	/*
	@Test
	public void calculateColumnTotalForNullValue() {
		mockingContext.checking(new Expectations() {
			{
				one(values2D).getRowCount();
				will(returnValue(1));
				one(values2D).getValue(0, 0); // int row, int column
				will(returnValue(null));			
			}
		});
		// exercise
		// Returns the total of the values in one column of the supplied data table.
		double result = DataUtilities.calculateColumnTotal(values2D, 0); 
		// verify
		assertEquals(result, 0.0d, .000000000d);
		// tear-down: NONE in this test method
	}
	*/
		
	@Test
	public void calculateColumnTotalForEmptyValues() {
		mockingContext.checking(new Expectations() {
			{
				one(values2D).getRowCount();
				will(returnValue(0));
			}
		});
		// exercise
		// Returns the total of the values in one column of the supplied data table.
		double result = DataUtilities.calculateColumnTotal(values2D, 0); 
		// verify
		assertEquals(result, 0, .000000001d);
		// tear-down: NONE in this test method
	}
	
	@Test
	public void calculateColumnTotalForPrecision() {
		mockingContext.checking(new Expectations() {
			{
				one(values2D).getRowCount();
				will(returnValue(2));
				one(values2D).getValue(0, 0); // int row, int column
				will(returnValue(5.6));
				one(values2D).getValue(1, 0); // int row, int column
				will(returnValue(5.8));				
			}
		});
		// exercise
		// Returns the total of the values in one column of the supplied data table.
		double result = DataUtilities.calculateColumnTotal(values2D, 0); 
		// verify
		assertEquals(result, 11.399999999999999d, 0d);
		// tear-down: NONE in this test method
	}	
	
	@After
	public void tearDown() throws Exception {

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {

	}
}
